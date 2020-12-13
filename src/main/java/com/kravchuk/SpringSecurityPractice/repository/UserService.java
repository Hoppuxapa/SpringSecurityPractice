package com.kravchuk.SpringSecurityPractice.repository;

import com.kravchuk.SpringSecurityPractice.domain.User;
import com.kravchuk.SpringSecurityPractice.dto.UserRegistrationDTO;

import java.util.List;


public interface UserService {

    User findByUsername(String username);

    List<User> getAllUsers();

    User findById(long id);

    User register(UserRegistrationDTO registration);
}