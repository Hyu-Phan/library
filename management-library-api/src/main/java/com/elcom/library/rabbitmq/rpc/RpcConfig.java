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
        @Bean("rpc_exchange_client")
        public DirectExchange directExchange() {
            return new DirectExchange("rpc_exchange");
        }
        @Bean
        public RpcClient rpcClient() {
            return new RpcClient();
        }
    }

    public static class ServerConfig {
        @Bean
        public Queue queue(){
            return new Queue("rpc_queue");
        }
        @Bean("rpcExchange")
        public DirectExchange directExchange() {
            return new DirectExchange("rpc_exchange");
        }
        @Bean
        public Binding binding( Queue queue,@Qualifier("rpcExchange") DirectExchange rpcExchange){
            return BindingBuilder.bind(queue).to(rpcExchange).with("rpc");
        }
        @Bean
        public RpcServer rpcServer(){
            return new RpcServer();
        }
    }

}
