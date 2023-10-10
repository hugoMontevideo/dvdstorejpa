package com.simplon.dvdstore.security;

import com.simplon.dvdstore.services.jwt.JwtUserService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

public class SecurityFilter extends OncePerRequestFilter {
    @Autowired
    private JwtUserService jwtUserService;
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        try {
            String header = request.getHeader("Authorization");
// Authentification
// Authorization: Bearer eyolfdilfsdkfdslkflsdkfjjdslfhlsdfjlsdfjlk
            String incomingJwt = header.substring(7);
            UserDetails userDetails = jwtUserService.getUserFromJwt(incomingJwt);
// On le passe aux controllers grâce au context
            Authentication authentication = new
                    UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
            SecurityContextHolder.getContext().setAuthentication(authentication);
        } catch (Exception e) {
            logger.info("Trying parse token but failed");
        }
        filterChain.doFilter(request, response);
    }

}
//Remarque : vérifie l'utilisateur associé à la requete HTTP et transmet le principal (le user) au reste de l'application via
//le SecurityContextHolder
