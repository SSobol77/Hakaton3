package com.example.demo.controllers;

import com.example.demo.models.Admins;
import com.example.demo.models.Users;
import com.example.demo.repo.AdminRepo;
import com.example.demo.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping ("/")
public class MainController {
    @Autowired
    UserRepo userRepo;
    @GetMapping
    public String getMainPage(){

        return "index";
    }
}
