package com.apexon.catchIt.controller;

import com.apexon.catchIt.dto.*;
import com.apexon.catchIt.model.User;
import com.apexon.catchIt.repositroy.UserRepo;
import com.apexon.catchIt.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
public class UserController {
    @Autowired
    UserServiceImpl userServiceImpl;

    @Autowired
    UserRepo userRepo;

    @PostMapping("/registerUser")
    public UserDto registerUser(@RequestBody UserRegisterDto user)
    {
        return userServiceImpl.registerUser(user);
    }

    @GetMapping("/getUserByName/{uname}")
    public Optional<User> getUser(@PathVariable String uname)
    {
        return userRepo.findByUserName(uname);
    }
    @GetMapping("/getUserById/{id}")
    public UserAdminDto getUserById(@PathVariable Long id)
    {
        UserAdminDto userDto=userServiceImpl.getUserById(id);
        return userDto;
    }
    @PutMapping("/updateUser/{id}")
    public UserDto updateUserById(@RequestBody UpdateUserDto user, @PathVariable Long id)
    {
        UserDto userDto=userServiceImpl.updateUser(user,id);
        return userDto;

    }
    @PutMapping("/updatePassword/{id}")
    public ResponseEntity<String> updateUserPassword(@RequestBody UpdatePasswordDto updatePasswordDto, @PathVariable Long id){
        userServiceImpl.updateUserPassword(id,updatePasswordDto);
       return new ResponseEntity<>("Password updated Successfully", HttpStatus.OK);
    }

    @GetMapping("/getAllUsers/{adminId}")
    public List<UserAdminDto> fetchAllUsersByAdminId(@PathVariable Long adminId){
        return userServiceImpl.fetchAllUsersByAdminId(adminId);
    }
    @PutMapping("/updateUserAccountDetails/{adminId}")
    public UserAdminDto updateUserAccountDetails(@PathVariable Long adminId,@RequestBody ManageUserAccountDto manageUserAccountDto){
        return userServiceImpl.updateUserAccountDetails(adminId,manageUserAccountDto);
    }
    @PutMapping("/assignRoles/{id}")
    public ResponseEntity<String> assignRoles(@RequestBody AssignRolesDto assignRolesDto, @PathVariable Long id) {
        try {
            userServiceImpl.assignRolesToUser(assignRolesDto.getUserId(), assignRolesDto.getRoles(), id);
            return ResponseEntity.ok("Roles updated successfully");
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(e.getMessage());
        }
    }
}
