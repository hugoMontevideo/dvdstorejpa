package com.simplon.dvdstore.controllers.auth;

import org.springframework.security.core.userdetails.UserDetails;

public class AuthResponseDto {
    private UserDetails user;
    private String token;

    public AuthResponseDto(UserDetails user, String token) {
        this.user = user;
        this.token = token;
    }

    public UserDetails getUser() {
        return user;
    }

    public void setUser(UserDetails user) {
        this.user = user;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
