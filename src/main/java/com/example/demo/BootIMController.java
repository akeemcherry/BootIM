package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class BootIMController {

    private final SimpMessagingTemplate template;

    @Autowired
    public BootIMController(SimpMessagingTemplate template) {
        this.template = template;
    }

    @MessageMapping("/send/message")
    public void onRecivedMessage(String message){
        this.template.convertAndSend("/chat", new SimpleDateFormat("HH:mm:ss").format(new Date()) + "- " + message);
    }
}
