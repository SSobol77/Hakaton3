package com.example.demo.controllers;

import com.example.demo.helpers.UserService;
import com.example.demo.models.Message;
import com.example.demo.repo.MessageRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    MessageRepo messageRepo;

    @GetMapping
    public String getMessages(Model model){
        List<Message> messages = messageRepo.findAllByUserId(UserService.id);
        model.addAttribute("msg", messages);
        return ("user");
    }
}
