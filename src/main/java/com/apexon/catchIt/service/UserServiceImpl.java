package com.apexon.catchIt.service;

import com.apexon.catchIt.dto.UserDto;
import com.apexon.catchIt.mapper.UserMapper;
import com.apexon.catchIt.model.User;
import com.apexon.catchIt.repositroy.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl {

    @Autowired
    UserRepo userRepo;
    @Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
    UserMapper userMapper;



    public User registerUser(User user)
    {
        if(userRepo.existsByEmail(user.getEmail()))
            throw new RuntimeException("Email already exists");
        System.out.println("User pass bfr encoding is "+user.getPassword());
        String encodedPassword=passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
        System.out.println("User pass after encdeing is "+user.getPassword());
        return userRepo.save(user);
    }
    public UserDto updateUser(User user, Long id)
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
       // userRepo.save(exisitngUser);
      return (userMapper.convertUserToUserDto(userRepo.save(exisitngUser)));


    }
    public UserDto getUserById(Long id)
    {
        Optional<User> user=userRepo.findById(id);
        if(!user.isPresent())
        {
            throw new RuntimeException("User not found with "+ id);
        }
        User exisitngUser=user.get();

        return userMapper.convertUserToUserDto(exisitngUser);

    }


}
