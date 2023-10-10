package com.simplon.dvdstore.controllers.auth;

import lombok.Data;

@Data
public class AuthRequestDto {
    private String username;
    private String password;
}
