package com.example.demo.controllers;

import com.example.demo.helpers.Type;
import com.example.demo.helpers.UserService;
import com.example.demo.models.Message;
import com.example.demo.repo.MessageRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@Controller
@RequestMapping("/chatWithUser")
public class ChatController {
    @Autowired
    MessageRepo messageRepo;

    @GetMapping
    public String getChat(Model model){
        List<Message> messages = messageRepo.findAllByUserId(UserService.id);
        model.addAttribute("msg", messages);
        return ("chat");
    }
    @PostMapping
    public RedirectView getChatM(@RequestParam String text){
        Message message = new Message();
        message.setAdminId(1);
        message.setId(10);
            message.setText(text + " by user");

        message.setIfRead(false);
        message.setUserId(UserService.id);;
        messageRepo.save(message);

        return new RedirectView("/chatWithUser");
    }
}
