package com.example.demo.repo;

import com.example.demo.models.Message;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MessageRepo extends JpaRepository<Message, Long> {
    List<Message> findAllByUserId(long id);
    Message findMessageByUserId(long id);
    Message findMessageById(long id);
    List<Message> findAllByIfRead(boolean ifRead);
}
