package com.cisco.test.controller;

import com.cisco.test.dto.User;
import com.cisco.test.util.UserValidation;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final List<User> users = new ArrayList<>();

    @PostMapping
    public void saveUser(@RequestBody User user) {
        UserValidation.validateUser(user);
        users.add(user);
    }

    @GetMapping
    public List<User> getAllUsers() {
        return users;
    }
}
