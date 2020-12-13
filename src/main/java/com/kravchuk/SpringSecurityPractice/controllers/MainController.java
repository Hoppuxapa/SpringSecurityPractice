package com.kravchuk.SpringSecurityPractice.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@Controller
public class MainController {

    @RequestMapping("/")
    public String root(@RequestHeader Map<String, String> headers) {
        return "index";
    }

    @RequestMapping("/login")
    public String login(Model model) {
        return "login";
    }

    @RequestMapping("/menu")
    public String menu(Model model) {
        model.addAttribute("Hello!");
        return "menu";
    }
    @RequestMapping("/user")
    public String userIndex() {
        return "user";
    }

    @GetMapping("registration")
    public String registration() {
        return "registration";
    }

    @RequestMapping("user/userEdit")
    public String userEdit() {
        return "user/userEdit";
    }
}

