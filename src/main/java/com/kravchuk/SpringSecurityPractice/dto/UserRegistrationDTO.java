package com.kravchuk.SpringSecurityPractice.dto;

import com.kravchuk.SpringSecurityPractice.domain.UserRole;
import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class UserRegistrationDTO {

    private String username;

    private String password;

    private String firstName;

    private String lastName;

    private String email;

    private int age;

    private UserRole role;
}
