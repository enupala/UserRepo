package com.apexon.catchIt.dto;

import com.apexon.catchIt.model.Role;
import com.apexon.catchIt.model.Roles;

public class UserRegisterDto {
    private String userName;
    private String email;
    private String password;
    private Role role;

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public UserRegisterDto() {
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserRegisterDto(String userName, String email, String password,Role role) {
        this.userName = userName;
        this.role=role;
        this.email = email;
        this.password = password;
    }


}
