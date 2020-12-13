package com.kravchuk.SpringSecurityPractice.controllers;

import com.kravchuk.SpringSecurityPractice.repository.UserRepository;
import com.kravchuk.SpringSecurityPractice.repository.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("users")
public class UserController {

    UserRepository userRepository;
    UserService userService;

    @Autowired
    public UserController(UserService userService, UserRepository userRepository) {
        this.userRepository = userRepository;
        this.userService = userService;
    }


    @GetMapping("/{id}")
    public String show(@PathVariable long id, Model model){
        model.addAttribute("user",userService.findById(id));
        return "users";
    }


    @RequestMapping("api/userList")
    public String listUsers(Model model) {
        model.addAttribute("users", userService.getAllUsers());
        return "userList";
    }
/*
    @PostMapping("/users")
    public String addNewUser(@ModelAttribute("user") User user){
        userService.saveUser(user);
        return "redirect:/users";
    }

    @GetMapping("/add_user")
    public String createUserPage(Model model){
        model.addAttribute("roles", UserRole.values());
        return "add-user";
    }

    @DeleteMapping("/user/{id}")
    public ResponseEntity<Long> deleteUser(@PathVariable("id") Long id){
        userService.deleteUser(id);
        return new ResponseEntity<>(id, HttpStatus.OK);
    }*/



}