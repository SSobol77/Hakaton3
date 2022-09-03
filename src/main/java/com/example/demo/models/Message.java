package com.example.demo.models;

import com.example.demo.helpers.Type;
import lombok.Data;

import javax.persistence.*;

@Table(name = "message_hakaton")
@Entity
@Data
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;

    @Column(name = "admin_id")
    long adminId;

    @Column(name = "user_id")
    long userId;

    @Column(name = "text")
    String text;

    @Column(name = "if_read")
    boolean ifRead;

    @Enumerated
    @Column(name = "type")
    Type type;
}
