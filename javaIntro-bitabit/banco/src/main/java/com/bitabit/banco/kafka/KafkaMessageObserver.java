package com.bitabit.banco.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.bitabit.banco.domain.model.Cliente;

@Component
public class KafkaMessageObserver {

    private static final Logger log = LoggerFactory.getLogger(KafkaMessageObserver.class);

    @KafkaListener(topics = "bitabit-topic-string", groupId = "observer-group")
    public void observeMessage(String message) {
        log.info("========================================");
        log.info("=== MENSAJE RECIBIDO EN bitabit-topic === " + message);
    }

    /**@KafkaListener(topics = "bitabit-topic-json", groupId = "observer-group")
    public void observeMessage(Cliente cliente) {
        log.info("========================================");
        log.info("=== CLIENTE PUBLICADO EN bitabit-topic === ");
        
    }*/
}

