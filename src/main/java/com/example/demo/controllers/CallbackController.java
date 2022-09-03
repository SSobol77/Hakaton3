package com.example.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/callback")
public class CallbackController {
    @GetMapping
    public String getCallback(){
        return ("callback");
    }
}
