package com.kravchuk.SpringSecurityPractice.controllers;

import com.kravchuk.SpringSecurityPractice.domain.User;
import com.kravchuk.SpringSecurityPractice.dto.UserRegistrationDTO;
import com.kravchuk.SpringSecurityPractice.profiling.ThrowException;
import com.kravchuk.SpringSecurityPractice.repository.UserService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.jdo.annotations.Join;
import javax.persistence.EntityNotFoundException;
@Configurable
@RestController
@RequestMapping("/registration")
@Data
public class RegistrationController {

    @Autowired
    private final UserService userService;

    public RegistrationController(UserService userService) {
        this.userService = userService;
    }


//    @ModelAttribute("user")
//    public UserRegistrationDTO userRegistrationDto() {
//        return new UserRegistrationDTO();
//    }

    @ThrowException
    @PostMapping
    @Join
    public String registerUserAccount(@ModelAttribute("user") UserRegistrationDTO userDto,
                                      BindingResult result) throws Exception {
        User existing = userService.findByUsername(userDto.getUsername());
        if (existing != null) {
            result.reject("There is already an account registered with that username");
            throw new Exception();
        }
        if (result.hasErrors()) {
            return "Error";
        }
        userService.register(userDto);
        return "OK";
    }

}

