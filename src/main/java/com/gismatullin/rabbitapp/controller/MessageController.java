package com.gismatullin.rabbitapp.controller;

import com.gismatullin.rabbitapp.consumer.Consumer;
import com.gismatullin.rabbitapp.producer.Producer;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessageController {
    
    @Autowired
    AmqpTemplate template;
    @Autowired
    Producer producer;
    @Autowired
    Consumer consumer;

    @GetMapping(path = "/send", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<Object> send(@RequestParam String message) {
        producer.send(message);
        return ResponseEntity.ok().build();
    }

    @GetMapping(path = "/read", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<Object> read() {
        String message = consumer.receive();
        return ResponseEntity.ok().body(message);
    }
}
