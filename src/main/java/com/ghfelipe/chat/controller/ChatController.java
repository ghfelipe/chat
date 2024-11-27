package com.ghfelipe.chat.controller;

import com.ghfelipe.chat.model.ChatMessage;
import com.ghfelipe.chat.model.OutputMessage;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class ChatController {

    @MessageMapping("/chat")
    @SendTo("/topic/messages")
    public OutputMessage sendMessage(@Payload ChatMessage chatMessage) {
        String time = new SimpleDateFormat("HH:mm").format(new Date());
        return new OutputMessage(chatMessage.getFrom(), chatMessage.getText(), time);
    }
}
