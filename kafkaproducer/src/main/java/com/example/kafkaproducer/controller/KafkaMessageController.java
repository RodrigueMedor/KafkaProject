package com.example.kafkaproducer.controller;

import com.example.kafkaproducer.model.IncomingMessage;
import com.example.kafkaproducer.service.KafkaProducerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class KafkaMessageController {

    private final KafkaProducerService producerService;

    @PostMapping
    public String sendMessageToKafka(@RequestBody IncomingMessage incomingMessage){
        producerService.sendMessage(incomingMessage.getTopic(), incomingMessage.getKey(), incomingMessage.getValue());
        return String.format("Success - Message for key %s is sent to kafka topic: %s", incomingMessage.getKey(), incomingMessage.getTopic());
    }
}
