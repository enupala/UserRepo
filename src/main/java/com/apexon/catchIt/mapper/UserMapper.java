package com.apexon.catchIt.mapper;

import com.apexon.catchIt.dto.UserAdminDto;
import com.apexon.catchIt.dto.UserDto;
import com.apexon.catchIt.dto.UserRegisterDto;
import com.apexon.catchIt.model.User;
import org.springframework.stereotype.Component;


@Component
public class UserMapper {
    public UserDto convertUserToUserDto(User user){
        UserDto userDto=new UserDto();
        userDto.setUserName(user.getUserName());
        userDto.setId(user.getId());
        userDto.setEmail(user.getEmail());
        userDto.setRole(user.getRole());
       /* userDto.setAccountLocked(user.isAccountLocked());
        userDto.setAccountExpired(user.isAccountExpired());
        userDto.setCredentialsExpired(user.isCredentialsExpired());*/
        return userDto;

    }
    public UserRegisterDto convertUserToUserRegisterDto(User user)
    {
        UserRegisterDto userRegisterDto=new UserRegisterDto();
        userRegisterDto.setPassword(user.getPassword());
        userRegisterDto.setUserName(user.getUserName());
        userRegisterDto.setEmail(user.getEmail());
        return userRegisterDto;
    }


    public UserAdminDto convertUserToUserAdminDto(User user) {
        UserAdminDto userAdminDto=new UserAdminDto();
        userAdminDto.setUserName(user.getUserName());
        userAdminDto.setId(user.getId());
        userAdminDto.setEmail(user.getEmail());
        userAdminDto.setRole(user.getRole());
        userAdminDto.setAccountLocked(user.isAccountLocked());
        userAdminDto.setAccountExpired(user.isAccountExpired());
        userAdminDto.setCredentialsExpired(user.isCredentialsExpired());
        return userAdminDto;
    }
}
