package com.apexon.catchIt.mapper;

import com.apexon.catchIt.dto.UserDto;
import com.apexon.catchIt.model.User;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;


@Component
public class UserMapper {
    public UserDto convertUserToUserDto(User user){
        UserDto userDto=new UserDto();
        userDto.setUserName(user.getUserName());
        userDto.setId(user.getId());
        userDto.setEmail(user.getEmail());
        userDto.setRole(user.getRole());
        userDto.setAccountLocked(user.isAccountLocked());
        userDto.setAccountExpired(user.isAccountExpired());
        userDto.setCredentialsExpired(user.isCredentialsExpired());
        return userDto;

    }


}
