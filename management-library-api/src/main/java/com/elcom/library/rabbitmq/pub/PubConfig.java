package com.elcom.library.rabbitmq.pub;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PubConfig {
    @Bean
    FanoutExchange fanoutExchange(){
        return new FanoutExchange("fanout exchange");
    }

    public static class MultiPubReceiver{
        //        PubReceiver1
        @Bean
        public Queue queue1() {
            return new AnonymousQueue();
        }
        @Bean
        public Binding binding1(FanoutExchange fanoutExchange, Queue queue1) {
            return BindingBuilder.bind(queue1).to(fanoutExchange);
        }
        @Bean
        public PubReceiver1 pubReceiver1() {
            return new PubReceiver1();
        }

        //        PubReceiver2
        @Bean
        public Queue queue2() {
            return new AnonymousQueue();
        }
        @Bean
        public Binding binding2(FanoutExchange fanoutExchange, Queue queue2) {
            return BindingBuilder.bind(queue2).to(fanoutExchange);
        }
        @Bean
        public PubReceiver2 pubReceiver2() {
            return new PubReceiver2();
        }
    }
}
