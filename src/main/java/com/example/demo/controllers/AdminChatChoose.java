package com.example.demo.controllers;

import com.example.demo.helpers.UserService;
import com.example.demo.models.Message;
import com.example.demo.repo.MessageRepo;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@Controller
@RequestMapping("/adminChat")
public class AdminChatChoose {

    @Autowired
    MessageRepo messageRepo;


    @GetMapping
    public String getPage(Model model){
        List<Message> list = messageRepo.findAllByIfRead(false);
        model.addAttribute("msg", list);
        return "adminchatchoose";
    }

    @PostMapping("/{id}/{uniqId}")
    public RedirectView re(@PathVariable long id,
                           @PathVariable long uniqId,
                           @RequestParam String text){
        Message message = new Message();
        message.setAdminId(1);
        message.setId(10);
        message.setText(text + " by admin");

        message.setIfRead(true);
        message.setUserId(id);
        messageRepo.save(message);

        Message message1 = new Message();
        message1 = messageRepo.findMessageById(uniqId);
        message1.setIfRead(true);
        messageRepo.save(message1);
        return new RedirectView("/adminChat");
    }
}
