package com.bitabit.banco.camel;

import com.bitabit.banco.domain.model.Cliente;
import com.bitabit.banco.infra.out.ClientePortOut;
import org.apache.camel.Exchange;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.rest.RestBindingMode;
import org.apache.camel.model.rest.RestParamType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.apache.camel.model.dataformat.JsonLibrary;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.kafka.support.KafkaHeaders;

import java.util.List;
import java.util.Optional;

@Component
public class RestApiRoute extends RouteBuilder {

    @Autowired
    private ClientePortOut clientePortOut;

    @Autowired
    private KafkaTemplate<String, Object> kafkaTemplate;

    @Override
    public void configure() throws Exception {

        // Configuración REST
        restConfiguration()
                .component("platform-http") // Usa platform-http para Spring Boot
                .bindingMode(RestBindingMode.json)
                .port(8080) // Puerto (opcional, usa el puerto de Spring Boot por defecto)
                .host("localhost") // Host
        ;

        // Definición de la API REST

        rest("/api/camel")
                .description("API REST expuesta con Apache Camel")

                // GET - Obtener todos los clientes
                .get("/clientes")
                .description("Obtener todos los clientes")
                .outType(List.class)
                .to("direct:getAllClientes")

                // GET - Obtener cliente por ID
                .get("/clientes/{id}")
                .description("Obtener cliente por ID")
                .param().name("id").type(RestParamType.path).description("ID del cliente").dataType("int").endParam()
                .outType(Cliente.class)
                .to("direct:getClienteById");

        // Rutas directas que procesan las peticiones e integran con los servicios

        from("direct:getAllClientes")
                .log("Obteniendo todos los clientes desde Camel")
                .process(exchange -> {
                    List<Cliente> clientes = clientePortOut.getAll();
                    exchange.getMessage().setBody(clientes);
                })
                .setHeader(Exchange.HTTP_RESPONSE_CODE, constant(200));

        from("direct:getClienteById")
                .log("Obteniendo cliente por ID desde Camel")
                .process(exchange -> {
                    int id = exchange.getMessage().getHeader("id", int.class);
                    Optional<Cliente> cliente = clientePortOut.getById(id);
                    if (cliente.isPresent()) {
                        exchange.getMessage().setBody(cliente.get());
                        exchange.getMessage().setHeader(Exchange.HTTP_RESPONSE_CODE, constant(200));
                        Message<Cliente> message = MessageBuilder
                                .withPayload(cliente.get())
                                .setHeader(KafkaHeaders.TOPIC, "bitabit-topic-json")
                                .build();
                        this.kafkaTemplate.send("bitabit-topic-string", cliente.get().toString());
                        //this.kafkaTemplate.send("bitabit-topic-json", message);
                    } else {
                        exchange.getMessage().setBody("Cliente no encontrado");
                        exchange.getMessage().setHeader(Exchange.HTTP_RESPONSE_CODE, constant(404));
                    }
                });

    }
}
