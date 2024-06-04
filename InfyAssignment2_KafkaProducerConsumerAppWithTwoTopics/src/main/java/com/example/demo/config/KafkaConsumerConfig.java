package com.example.demo.config;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumerConfig {

    @KafkaListener(topics = "pal_case_destination", groupId = "group_id")
    public void listen(String message) {
        System.out.println("Received Message in group 'group_id': " + message);
    }
}

