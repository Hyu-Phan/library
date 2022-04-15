package com.elcom.library.rabbitmq.rpc;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;


@RabbitListener(queues = "rpc_queue")
public class RpcServer {
    @RabbitHandler
    public String doWork(String task) throws InterruptedException {
        System.out.println("Server: received " + task);
        System.out.println("Server: is doing....");
        Thread.sleep(2000);
        return "Task completed";
    }
}
