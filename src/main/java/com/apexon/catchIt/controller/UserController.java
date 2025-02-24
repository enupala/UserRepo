package com.apexon.catchIt.controller;

import com.apexon.catchIt.dto.UserDto;
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
    public UserDto getUserById(@PathVariable Long id)
    {
        UserDto userDto=userServiceImpl.getUserById(id);
        return userDto;
    }
    @PutMapping("/updateUser/{id}")
    public UserDto updateUserById(@RequestBody User user, @PathVariable Long id)
    {
        UserDto userDto=userServiceImpl.updateUser(user,id);
        return userDto;

    }
}
