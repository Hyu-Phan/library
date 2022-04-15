package com.elcom.library.rabbitmq.woker;


import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class WorkerSender {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    @Qualifier("worker_queue")
    private Queue queue;

    public void send(int numOfTasks) {
        int tasks = 0;
        int numOfChar = 0;
        while(numOfTasks > 0) {
            numOfTasks--;
            if(numOfChar >3){
                numOfChar = 0;
            }
            numOfChar ++;
            tasks ++;
            StringBuilder stringBuilder = new StringBuilder("Task " + tasks + ":" );
            for(int i = 0; i< numOfChar; i++){
                stringBuilder.append('-');
            }
            String message = stringBuilder.toString();
            rabbitTemplate.convertAndSend(queue.getName(), message);
            System.out.println("Send: " + message);
        }
    }
}
