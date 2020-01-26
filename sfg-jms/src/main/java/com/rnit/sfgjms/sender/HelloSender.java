package com.rnit.sfgjms.sender;

import com.rnit.sfgjms.config.JmsConfig;
import com.rnit.sfgjms.model.HelloWorldMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.UUID;

// @RequiredArgsConstructor
@Component
public class HelloSender {
    private final JmsTemplate jmsTemplate;
    public HelloSender(JmsTemplate jmsTemplate){
        this.jmsTemplate = jmsTemplate;
    }
    @Scheduled(fixedRate = 2000)
    public void sendMessage(){
        System.out.println("I'm sending a msg");
//        HelloWorldMessage message = HelloWorldMessage
//                .builder()
//                .id(UUID.randomUUID())
//                .message("Hello World!")
//                .build();
        HelloWorldMessage message = new HelloWorldMessage();
        message.setId(UUID.randomUUID());
        message.setMessage("Hello Message");
        jmsTemplate.convertAndSend(JmsConfig.MY_QUEYE, message);
        System.out.println("Message Sent");
    }
}
