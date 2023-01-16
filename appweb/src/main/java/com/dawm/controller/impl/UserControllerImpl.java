package com.dawm.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.dawm.controller.UserController;
import com.dawm.model.UserData;
import com.dawm.service.UserService;

@RestController
public class UserControllerImpl implements UserController {

    @Autowired
    private UserService userService;
    
    @PostMapping("/user")
    public void addUser(@RequestBody UserData userData){
        this.userService.addUser(userData);
    }
    
}
