package com.w_farooq_group.user.controller;

import com.w_farooq_group.shared.constants.AppConstants;
import com.w_farooq_group.shared.dto.ResponseDto;
import com.w_farooq_group.user.requests.CustomerRegistrationRequest;
import com.w_farooq_group.user.requests.LoginRequest;
import com.w_farooq_group.user.requests.UserRegistrationRequest;
import com.w_farooq_group.user.service.impl.AuthService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/v1/auth", produces = {MediaType.APPLICATION_JSON_VALUE})
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }


    @PostMapping("/register")
    public ResponseEntity<ResponseDto> registerUser (@RequestBody CustomerRegistrationRequest userRegistrationRequest) {
        String res = authService.registerUser(userRegistrationRequest);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(new ResponseDto(AppConstants.STATUS_201,res));
    }

    @PostMapping("/login")
    public ResponseEntity<ResponseDto> login (@RequestBody LoginRequest loginRequest) {
       String res =  authService.login(loginRequest);
       return ResponseEntity.status(HttpStatus.OK).body(new ResponseDto(AppConstants.STATUS_200, res));
    }

}
