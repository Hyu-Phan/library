package com.elcom.library.rabbitmq.message;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;

@Service
@RabbitListener(queues = "${spring.rabbitmq.queue}")
public class Receiver {

    @RabbitHandler
    public void received(String message){
        System.out.println("Receive message: " + message);
    }
}
