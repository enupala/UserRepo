package com.apexon.catchIt.config;

public class AuthResponse {
    public AuthResponse(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    private String token;
}
