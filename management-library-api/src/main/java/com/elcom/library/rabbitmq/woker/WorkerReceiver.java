package com.elcom.library.rabbitmq.woker;

import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.Connection;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;

import java.io.IOException;

@RabbitListener(queues = "workerQueue")
public class WorkerReceiver {
    private final int id;
    private int numberOfTasks;
    public WorkerReceiver(int id) {
        this.id = id;
        this.numberOfTasks = 0;
    }

    @RabbitHandler
    public void received(String message, Channel channel) throws InterruptedException, IOException {
//        channel.basicQos(1);
//        channel.basicConsume("worker_queue", false, channel.getDefaultConsumer());
//        long deliveryTag = channel.basicGet("worker_queue", false).getEnvelope().getDeliveryTag();

        for(char c : message.toCharArray()){
            if(c == '-'){
                if(id == 1){
                    Thread.sleep(500);
                }
                else {
                    Thread.sleep(1000);
                }
            }
        }
//        channel.basicAck(deliveryTag, false);
        numberOfTasks++;
        System.out.println("Worker " + id + " completed " + numberOfTasks + " tasks");
    }
}
