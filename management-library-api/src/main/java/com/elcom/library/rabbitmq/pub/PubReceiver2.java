package com.elcom.library.rabbitmq.pub;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;


@RabbitListener(queues = "#{queue2.name}")
public class PubReceiver2 {
    @RabbitHandler
    public void received(String message) {
        System.out.println("Receiver 2 : " + message);
    }
}
