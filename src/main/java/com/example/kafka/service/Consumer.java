package com.example.kafka.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class Consumer {
    private static final Logger log = LoggerFactory.getLogger(Consumer.class);

    @Autowired
    private final ObjectMapper mapper = new ObjectMapper();

    @KafkaListener(topics = "demo", groupId = "group_id")
    public void consume(String message) throws IOException {
        log.info(String.format("consumed message is: %s", message));
    }
}
