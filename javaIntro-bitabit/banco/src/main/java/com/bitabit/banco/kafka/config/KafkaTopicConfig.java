package com.bitabit.banco.kafka.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.apache.kafka.common.config.TopicConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class KafkaTopicConfig {

    @Bean
    public NewTopic generateTopic() {

        Map<String, String> configurations = new HashMap<>();
        configurations.put(TopicConfig.CLEANUP_POLICY_CONFIG, TopicConfig.CLEANUP_POLICY_DELETE);
        configurations.put(TopicConfig.RETENTION_MS_CONFIG, "3600000"); // 1 hora de retencion de mensajes
        configurations.put(TopicConfig.SEGMENT_BYTES_CONFIG, "1073741824" ); // 1 GB Max Size segment
        configurations.put(TopicConfig.MAX_MESSAGE_BYTES_CONFIG, "10485760"); // 10 MB maximo tamaño de mensaje

        return TopicBuilder.name("bitabit-topic")
                .partitions(3)
                .replicas(1)
                .configs(configurations)
                .build();
    }
}
