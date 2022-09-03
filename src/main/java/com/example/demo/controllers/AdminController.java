package com.example.demo.controllers;

import com.example.demo.repo.AdminRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    AdminRepo adminRepo;

    @GetMapping
    public String getMessage () {
        return  ("admin");
    }
}
