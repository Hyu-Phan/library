package com.elcom.library.rabbitmq.rpc;


import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.Scheduled;

public class RpcClient {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    @Qualifier("rpc_exchange_client")
    private DirectExchange directExchange;

    public void sendTask(String message) {
        System.out.println("Client: Send task to server");
        String result = (String) rabbitTemplate.convertSendAndReceive(directExchange.getName(),message);
        System.out.println("Client: " + result);
    }
}
