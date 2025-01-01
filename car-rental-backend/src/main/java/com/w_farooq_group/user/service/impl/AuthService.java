package com.w_farooq_group.user.service.impl;

import com.w_farooq_group.config.security.CustomUserDetails;
import com.w_farooq_group.config.security.CustomUserDetailsService;
import com.w_farooq_group.user.entity.User;
import com.w_farooq_group.user.requests.LoginRequest;
import com.w_farooq_group.user.requests.UserRegistrationRequest;
import com.w_farooq_group.user.service.IUserService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    private final IUserService iUserService;
    private final AuthenticationManager authenticationManager;


    public AuthService(IUserService iUserService, AuthenticationManager authenticationManager) {
        this.iUserService = iUserService;
        this.authenticationManager = authenticationManager;
    }

    public String registerUser (UserRegistrationRequest registrationRequest) {
        String res = iUserService.registerUser(registrationRequest);
        System.out.println(registrationRequest.getPassword());
        return res;
    }

    public String login (LoginRequest loginRequest) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginRequest.getEmail(),
                        loginRequest.getPassword()
                )
        );

        if (!authentication.isAuthenticated())
            throw new BadCredentialsException("incorrect username password");

        SecurityContextHolder.getContext().setAuthentication(authentication);
        CustomUserDetails customUserDetails = (CustomUserDetails) authentication.getPrincipal();
        return "Logged in successfully";
    }

}
