package com.dawm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.stereotype.Service;

import com.dawm.model.User;
import com.dawm.model.UserData;
import com.dawm.service.UserService;

@Service
public class UserServiceImpl implements UserService {
    
    @Autowired
    private JdbcUserDetailsManager jdbcUserDetailsManager;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Override
    public void addUser(UserData userData) {
        User user = new User();

        user.setUsername(userData.getUsername());
        user.setPassword(passwordEncoder.encode(userData.getPassword()));
        user.setEnabled(true);

        this.jdbcUserDetailsManager.createUser(user);
    }

}
