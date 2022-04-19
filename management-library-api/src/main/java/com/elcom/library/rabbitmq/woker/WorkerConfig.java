package com.elcom.library.rabbitmq.woker;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WorkerConfig {
    @Bean(name = "workerQueue")
    public Queue queue() {
        return  new Queue("workerQueue");
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
