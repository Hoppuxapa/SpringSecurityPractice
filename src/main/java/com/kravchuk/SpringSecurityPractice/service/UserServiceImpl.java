package com.kravchuk.SpringSecurityPractice.service;

import com.kravchuk.SpringSecurityPractice.profiling.ApiLog;
import com.kravchuk.SpringSecurityPractice.repository.UserRepository;
import com.kravchuk.SpringSecurityPractice.domain.User;
import com.kravchuk.SpringSecurityPractice.domain.UserRole;
import com.kravchuk.SpringSecurityPractice.dto.UserRegistrationDTO;
import com.kravchuk.SpringSecurityPractice.repository.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;


@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> getAllUsers() {
        return new ArrayList<>(userRepository.findAll());
    }

    @Override
    @ApiLog
    public User findByUsername(String username) {

        User userFromDB = userRepository.findByUsername(username).orElse(null);

        return userFromDB;
    }

    @Override
    public User findById(long id) {

        User userFromDB = userRepository.findById(id);

        return userFromDB;
    }

    @Override
    @ApiLog
    public User register(UserRegistrationDTO registration) {
        User user = new User();
        user.setEmail(registration.getEmail());
        user.setPassword(registration.getPassword());
        user.setUsername(registration.getUsername());
        user.setAge(registration.getAge());
        user.setFirstName(registration.getFirstName());
        user.setLastName(registration.getLastName());
        user.setUserRole(UserRole.USER);
        userRepository.save(user);
        return user;
    }
}


