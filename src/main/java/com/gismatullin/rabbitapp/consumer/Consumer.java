package com.gismatullin.rabbitapp.consumer;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Consumer {

    @Autowired
    private AmqpTemplate template;
    @Autowired
    private Queue queue;
    private final Logger LOGGER = LogManager.getLogger();

    public String receive() {
        Message messageObject = template.receive(queue.getName());
        String message = new String(messageObject.getBody());
        LOGGER.info("Message is received from queue " + queue.getName());
        return message;
    }

}
