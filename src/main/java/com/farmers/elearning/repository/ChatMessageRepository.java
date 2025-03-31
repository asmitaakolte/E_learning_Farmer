package com.farmers.elearning.repository;

import com.farmers.elearning.model.ChatMessage;
import com.farmers.elearning.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ChatMessageRepository extends JpaRepository<ChatMessage, Long> {
    // Custom query to find messages by sender and receiver
    List<ChatMessage> findBySenderAndReceiver(User sender, User receiver);
}
