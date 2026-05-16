package com.example.sd21102.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/account")
public class AccountController {

    @GetMapping("/login")
    public String login() {
        return "login.html";
    }

//    String uri = request.get...("username");
    @PostMapping("/login")
    public String login(
            @RequestParam("username") String username,
            @RequestParam("password") String password
    ) {
        System.out.println(username);
        System.out.println(password);
        return null;
    }

}
