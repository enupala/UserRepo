package com.apexon.catchIt.controller;

import com.apexon.catchIt.model.User;
import com.apexon.catchIt.repositroy.UserRepo;
import com.apexon.catchIt.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;

@RestController
public class UserController {
    @Autowired
    UserServiceImpl userServiceImpl;

    @Autowired
    UserRepo userRepo;

    @PostMapping("/registerUser")
    public User registerUser(@RequestBody User user)
    {
        return userServiceImpl.registerUser(user);
    }

    @GetMapping("/getUserByName/{uname}")
    public Optional<User> getUser(@PathVariable String uname)
    {
        return userRepo.findByUserName(uname);
    }
    @GetMapping("/getUserById/{id}")
    public Optional<User> getUserById(@PathVariable Long id)
    {
        return userRepo.findById(id);
    }
    @PutMapping("/updateUser/{id}")
    public User updateUserById(@RequestBody User user,@PathVariable Long id)
    {
       return userServiceImpl.updateUser(user,id);
    }
}
