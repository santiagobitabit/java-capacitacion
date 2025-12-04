/**package com.bitabit.banco.camel;

import org.springframework.stereotype.Component;
import org.apache.camel.builder.RouteBuilder;

@Component
public class AutomaticMessageRoute extends RouteBuilder {

    @Override
    public void configure() throws Exception {
        from("timer:my-timer?period=30s")
        .log("Haciendo llamada a API...")
        .to("https://68dbf993445fdb39dc2747d4.mockapi.io/api/ext/input-clientes")
        .log("Respuesta de la API: ${body}")
        .end();
    }
}*/
