package com.dawm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.stereotype.Service;

import com.dawm.model.User;
import com.dawm.service.UserService;

@Service
public class UserServiceImpl implements UserService {
    
    @Autowired
    private JdbcUserDetailsManager jdbcUserDetailsManager;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Override
    public void addUser(String username, String password) {
        User user = new User();

        user.setUsername(username);
        user.setPassword(passwordEncoder.encode(password));
        user.setEnabled(true);

        this.jdbcUserDetailsManager.createUser(user);
    }

}
