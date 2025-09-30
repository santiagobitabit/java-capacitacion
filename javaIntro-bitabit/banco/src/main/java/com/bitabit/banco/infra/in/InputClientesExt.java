package com.bitabit.banco.infra.in;

import com.bitabit.banco.domain.model.Cliente;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

@Service
public class InputClientesExt {

        private final WebClient webClient;

        public InputClientesExt(WebClient.Builder webClientBuilder) {
            this.webClient = webClientBuilder.baseUrl("https://68dbf993445fdb39dc2747d4.mockapi.io/api/ext").build();
        }

        public Flux<Cliente> someRestCall() {
            return this.webClient.get().uri("/input-clientes").retrieve().bodyToFlux(Cliente.class);
        }
}
