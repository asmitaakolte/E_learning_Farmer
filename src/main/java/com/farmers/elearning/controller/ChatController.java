package com.farmers.elearning.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.farmers.elearning.model.ChatMessage;
import com.farmers.elearning.services.ChatService;


@RestController
@RequestMapping("/api/chat")
public class ChatController {

    @Autowired
    private ChatService chatService;

    // Get chat history between two users
    @GetMapping("/{senderId}/{receiverId}")
    public List<ChatMessage> getChatHistory(@PathVariable Long senderId, @PathVariable Long receiverId) {
        return chatService.getChatMessages(senderId, receiverId);
    }

    // Send a message from one user to another
    @PostMapping("/{senderId}/{receiverId}")
    public void sendMessage(@PathVariable Long senderId, @PathVariable Long receiverId, @RequestBody String messageContent) {
        chatService.sendMessage(senderId, receiverId, messageContent);
    }
}

