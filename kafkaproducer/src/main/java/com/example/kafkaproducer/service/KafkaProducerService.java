package com.example.kafkaproducer.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@Log4j2
@RequiredArgsConstructor
public class KafkaProducerService {

    private final KafkaTemplate<String, String> kafkaTemplate;

    public void sendMessage(String topic, String key, String value){
        log.info(String.format("Producing Message - Key : %s, value: %s to topic: %s",key, value, topic ));
        kafkaTemplate.send(topic, key, value);
    }
}
