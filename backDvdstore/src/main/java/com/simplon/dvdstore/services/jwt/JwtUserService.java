package com.simplon.dvdstore.services.jwt;

import com.simplon.dvdstore.services.user.UserService;
import org.springframework.security.core.userdetails.UserDetails;

public interface JwtUserService extends UserService {
    String generateJwtForUser(UserDetails user);
    UserDetails getUserFromJwt(String jwt);
}
