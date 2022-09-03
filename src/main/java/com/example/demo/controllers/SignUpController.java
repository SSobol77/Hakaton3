package com.example.demo.controllers;

import com.example.demo.models.Users;
import com.example.demo.repo.UserRepo;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@RequestMapping("/signup")
public class SignUpController {
    @Autowired
    UserRepo userRepo;

    @GetMapping
    public String getSignUp (){
        return "signup";
    }

    @PostMapping
    public RedirectView setData (@RequestParam String name,
                                 @RequestParam String lastname,
                                 @RequestParam String email,
                                 @RequestParam String password){
        Users users = new Users();
        users.setName(name);
        users.setLastname(lastname);
        users.setEmail(email);
        users.setPassword(password);
        userRepo.save(users);
        return new RedirectView("/");
    }
}
