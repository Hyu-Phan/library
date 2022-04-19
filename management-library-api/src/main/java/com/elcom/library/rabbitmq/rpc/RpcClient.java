package com.elcom.library.rabbitmq.rpc;


import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class RpcClient {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    @Qualifier("exchangeServer")
    private DirectExchange directExchange;

    public int sendTask(int num) {
        System.out.println("Client: Send task to server");
        Integer result = (Integer) rabbitTemplate.convertSendAndReceive(directExchange.getName(), "rpc",num);
        return result;
    }
}
