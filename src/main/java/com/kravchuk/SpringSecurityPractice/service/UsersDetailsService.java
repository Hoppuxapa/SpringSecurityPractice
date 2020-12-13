package com.kravchuk.SpringSecurityPractice.service;

import com.kravchuk.SpringSecurityPractice.domain.User;
import com.kravchuk.SpringSecurityPractice.domain.UserPrincipal;
import com.kravchuk.SpringSecurityPractice.profiling.ThrowException;
import com.kravchuk.SpringSecurityPractice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UsersDetailsService implements UserDetailsService {

    private UserRepository userRepository;

    @Autowired
    public UsersDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    @ThrowException
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        final User user = userRepository.findByUsername(username).orElseThrow(() ->
                new UsernameNotFoundException(String.format("user with email %s not exists", username)));
        return new UserPrincipal(user);
    }
}