package com.farmers.elearning.services;

import com.farmers.elearning.model.ChatMessage;
import com.farmers.elearning.repository.ChatMessageRepository;
import com.farmers.elearning.repository.UserRepository;
import com.farmers.elearning.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ChatService {

    @Autowired
    private ChatMessageRepository chatMessageRepository;

    @Autowired
    private UserRepository userRepository;

    // Fetch chat messages between users
    public List<ChatMessage> getChatMessages(Long senderId, Long receiverId) {
        User sender = userRepository.findById(senderId).orElseThrow(() -> new RuntimeException("Sender not found"));
        User receiver = userRepository.findById(receiverId).orElseThrow(() -> new RuntimeException("Receiver not found"));
        
        return chatMessageRepository.findBySenderAndReceiver(sender, receiver);
    }

    // Save a new message
    public void sendMessage(Long senderId, Long receiverId, String messageContent) {
        User sender = userRepository.findById(senderId).orElseThrow(() -> new RuntimeException("Sender not found"));
        User receiver = userRepository.findById(receiverId).orElseThrow(() -> new RuntimeException("Receiver not found"));
        
        ChatMessage message = new ChatMessage();
        message.setSender(sender);
        message.setReceiver(receiver);
        message.setContent(messageContent);
        
        chatMessageRepository.save(message);
    }
}
