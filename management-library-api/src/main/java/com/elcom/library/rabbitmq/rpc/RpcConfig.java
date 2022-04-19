package com.elcom.library.rabbitmq.rpc;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RpcConfig {

    public static class ClientConfig{
        @Bean("exchangeClient")
        public DirectExchange directExchange() {
            return new DirectExchange("rpcExchange");
        }
        @Bean
        public RpcClient rpcClient() {
            return new RpcClient();
        }
    }

    public static class ServerConfig {
        @Bean("rpcQueue")
        public Queue queue(){
            return new Queue("rpcQueue");
        }
        @Bean("exchangeServer")
        public DirectExchange directExchange() {
            return new DirectExchange("rpcExchange");
        }
        @Bean
        public Binding binding(@Qualifier("rpcQueue") Queue queue,@Qualifier("exchangeServer") DirectExchange rpcExchange){
            return BindingBuilder.bind(queue).to(rpcExchange).with("rpc");
        }
        @Bean
        public RpcServer rpcServer(){
            return new RpcServer();
        }
    }

}
