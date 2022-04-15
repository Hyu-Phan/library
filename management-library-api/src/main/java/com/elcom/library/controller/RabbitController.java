package com.elcom.library.controller;

import com.elcom.library.rabbitmq.message.Sender;
import com.elcom.library.rabbitmq.pub.PubSender;
import com.elcom.library.rabbitmq.rpc.RpcClient;
import com.elcom.library.rabbitmq.woker.WorkerSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/rabbitmq")
public class RabbitController {
    @Autowired
    private Sender sender;

    @Autowired
    private WorkerSender workerSender;

    @Autowired
    private PubSender publisherSender;

    @Autowired
    private RpcClient rpcClient;

    @GetMapping("/send")
    public ResponseEntity<?> sendMessage(@RequestParam String message){
        sender.send(message);
        return ResponseEntity.ok("Send message successfully");
    }

    @GetMapping("/worker")
    public ResponseEntity<?> doTasks(@RequestParam("numOfTasks") int numOfTasks){
        workerSender.send(numOfTasks);
        return ResponseEntity.ok("Send tasks successfully");
    }

    @GetMapping("/pub")
    public ResponseEntity<?> sendPublisherMessage(@RequestParam String message) {
        publisherSender.send(message);
        return ResponseEntity.ok("Send message successfully");
    }

    @GetMapping("/rpc")
    public ResponseEntity<?> sendRpcMessage(@RequestParam String message){
        rpcClient.sendTask(message);
        return ResponseEntity.ok("Send message successfully");
    }

}
