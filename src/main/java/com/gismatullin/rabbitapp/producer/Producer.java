package com.gismatullin.rabbitapp.producer;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Producer {

    @Autowired
    private AmqpTemplate template;
    @Autowired
    private Queue queue;

    private final Logger LOGGER = LogManager.getLogger();

    public void send(String message) {
        Message messageObject = new Message(message.getBytes());
        template.convertAndSend(queue.getName(), messageObject);
        LOGGER.info("Message is sent to queue " + queue.getName());
    }
    
}
