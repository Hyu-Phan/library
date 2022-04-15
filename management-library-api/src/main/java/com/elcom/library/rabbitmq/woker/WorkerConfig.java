package com.elcom.library.rabbitmq.woker;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WorkerConfig {
    @Bean(name = "worker_queue")
    public Queue queue() {
        return  new Queue("worker_queue");
    }

    public static class Receiver {
        @Bean
        public WorkerReceiver workerReceiver1(){ return new WorkerReceiver(1);}
        @Bean
        public WorkerReceiver workerReceiver2(){ return new WorkerReceiver(2);}
    }

    @Bean
    public WorkerSender workerSender(){ return new WorkerSender();}
}
