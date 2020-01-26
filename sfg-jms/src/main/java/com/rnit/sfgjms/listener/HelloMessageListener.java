package com.rnit.sfgjms.listener;

import com.rnit.sfgjms.config.JmsConfig;
import com.rnit.sfgjms.model.HelloWorldMessage;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.MessageHeaders;
import org.springframework.stereotype.Component;

import javax.jms.Message;

@Component
public class HelloMessageListener {

    @JmsListener(destination = JmsConfig.MY_QUEYE)
    public void listen(HelloWorldMessage helloWorldMessage, MessageHeaders messageHeaders, Message message){
        System.out.println("I Got a Message");
        System.out.println(helloWorldMessage);

        // throw new RuntimeException("something wrong");
    }
}
