package com.simplon.dvdstore.services.user;

import com.simplon.dvdstore.exceptions.AccountExistsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {
    Authentication authenticate(String username, String password) throws Exception;
    UserDetails save(String username, String password) throws AccountExistsException;
}
