package com.apexon.catchIt.service;

import com.apexon.catchIt.model.User;
import com.apexon.catchIt.repositroy.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl {

    @Autowired
    UserRepo userRepo;

    public User registerUser(User user)
    {
        if(userRepo.existsByEmail(user.getEmail()))
            throw new RuntimeException("Email already exists");

        return userRepo.save(user);
    }
    public User updateUser(User user,Long id)
    {
        if(userRepo.existsByEmailAndIdNot(user.getEmail(),id))
        {
            throw new RuntimeException("Email already exists");
        }
        Optional<User> optionalUser=userRepo.findById(id);
        if(!optionalUser.isPresent())
        {
            throw new RuntimeException("user not found with "+id);
        }
        User exisitngUser= optionalUser.get();
        exisitngUser.setUserName(user.getUserName());
        exisitngUser.setEmail(user.getEmail());
        /*exisitngUser.setPassword(user.getPassword());
        exisitngUser.setRoles(user.getRoles());*/

       return userRepo.save(exisitngUser);

    }
}
