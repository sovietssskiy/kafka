package com.landin.producer.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.config.TopicBuilder;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.listener.ConcurrentMessageListenerContainer;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class Config {

    private final KafkaProperties kafkaProperties;

    private String topicName = "t.film.review";

    @Autowired
    public Config(KafkaProperties kafkaProperties) {
        this.kafkaProperties = kafkaProperties;
    }
    @Autowired
    private ConcurrentKafkaListenerContainerFactory<String, String> kafkaListenerContainerFactory;

    @Bean
    public ProducerFactory<String, String> producerFactory() {
        // get configs on application.properties/yml
        Map<String, Object> properties = kafkaProperties.buildProducerProperties();
//        Map<String, Object> properties = new HashMap<>();
        ConcurrentMessageListenerContainer<String, String> container = kafkaListenerContainerFactory.createContainer(topicName);
        String groupId = container.getContainerProperties().getGroupId();
        System.out.println("Group id of topic " + topicName + " is " + groupId);
        return new DefaultKafkaProducerFactory<>(properties);
    }


    @Bean
    public KafkaTemplate<String, String> kafkaTemplate() {
        return new KafkaTemplate<>(producerFactory());
    }

    @Bean
    public NewTopic topic() {
        return TopicBuilder
                .name("t.film.review")
                .partitions(1)
                .replicas(1)
                .build();
    }
    @Bean
    public NewTopic topicF() {
        return TopicBuilder
                .name("t.film.film")
                .partitions(1)
                .replicas(1)
                .build();
    }
    @Bean
    public RestTemplate restTemplate () {
        return new RestTemplate();
    }

}
