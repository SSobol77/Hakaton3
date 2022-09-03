package com.example.demo.controllers;

import com.example.demo.helpers.UserService;
import com.example.demo.models.Admins;
import com.example.demo.models.Users;
import com.example.demo.repo.AdminRepo;
import com.example.demo.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@RequestMapping("/login")
public class LogInController {
    @GetMapping
    public String getLogIn(){
        return "login";
    }

    @Autowired
    AdminRepo adminRepo;

    @Autowired
    UserRepo userRepo;

    @PostMapping
    public RedirectView setData(@RequestParam String username,
                                @RequestParam String password){
        Users users = null;
        users = userRepo.findByNameAndPassword(username, password);
        Admins admins = null;
        if (users==null){
            admins = adminRepo.findByNameAndPassword(username, password);
        }
        if (users==null&&admins==null){
           return new RedirectView("/no");
        }
        else if (users.getName().equals("admin")){
            return new RedirectView("/admin");
        }else {
            UserService.id = users.getId();
            return new RedirectView("/user");
        }
    }

}
