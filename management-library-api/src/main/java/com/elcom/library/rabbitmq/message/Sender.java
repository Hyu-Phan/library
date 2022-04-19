package com.elcom.library.rabbitmq.message;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class Sender {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    @Qualifier("queue")
    private Queue queue;

    public void send(String message){
        rabbitTemplate.convertAndSend(queue.getName(), message);
        System.out.println("Send message " + "hello");
    }
}
