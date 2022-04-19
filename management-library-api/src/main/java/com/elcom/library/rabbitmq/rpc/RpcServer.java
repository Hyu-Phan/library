package com.elcom.library.rabbitmq.rpc;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;



public class RpcServer {
    @RabbitListener(queues = "rpcQueue")
    public int doWork(int num) throws InterruptedException {
        System.out.println("Server: received " + num);
        return factorial(num);
    }

    public int factorial(int n){
        if(n == 1) return 1;
        return n * factorial(n-1);
    }
}
