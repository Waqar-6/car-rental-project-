package com.w_farooq_group.user.controller;

import com.w_farooq_group.shared.constants.AppConstants;
import com.w_farooq_group.shared.dto.ResponseDto;
import com.w_farooq_group.user.dto.CustomerDto;
import com.w_farooq_group.user.service.IUserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/v1/users", produces = {MediaType.APPLICATION_JSON_VALUE})
public class UserController {

    private final IUserService iUserService;

    public UserController(IUserService iUserService) {
        this.iUserService = iUserService;
    }

    @PutMapping("/update")
    public ResponseEntity<ResponseDto> updateCustomer (@PathVariable String email, @RequestBody CustomerDto customerDto) {
        boolean isUpdated = iUserService.updateUser(email, customerDto);
        return isUpdated ? ResponseEntity.status(HttpStatus.OK)
                .body(new ResponseDto(AppConstants.STATUS_200, "updated")) :
        ResponseEntity.status(HttpStatus.EXPECTATION_FAILED)
                .body(new ResponseDto(AppConstants.STATUS_417, AppConstants.MESSAGE_417_UPDATE));
    }
}
