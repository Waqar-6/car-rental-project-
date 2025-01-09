package com.w_farooq_group.user.controller;

import com.w_farooq_group.shared.constants.AppConstants;
import com.w_farooq_group.shared.dto.ResponseDto;
import com.w_farooq_group.user.dto.CustomerDto;
import com.w_farooq_group.user.service.IUserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(value = "/api/v1/users", produces = {MediaType.APPLICATION_JSON_VALUE})
public class UserController {

    private final IUserService iUserService;

    public UserController(IUserService iUserService) {
        this.iUserService = iUserService;
    }

    @PreAuthorize("hasRole('CUSTOMER')")
    @PutMapping("/update")
    public ResponseEntity<ResponseDto> updateCustomer (@PathVariable String email, @RequestBody CustomerDto customerDto) {
        boolean isUpdated = iUserService.updateUser(email, customerDto);
        return isUpdated ? ResponseEntity.status(HttpStatus.OK)
                .body(new ResponseDto(AppConstants.STATUS_200, "updated")) :
        ResponseEntity.status(HttpStatus.EXPECTATION_FAILED)
                .body(new ResponseDto(AppConstants.STATUS_417, AppConstants.MESSAGE_417_UPDATE));
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/fetch/customers")
    public ResponseEntity<List<CustomerDto>> fetchAllCustomers () {
        List<CustomerDto> customerDtoList = iUserService.getAllCustomers();
        return new ResponseEntity<>(customerDtoList, HttpStatus.OK);
    }

    @GetMapping("/fetch/customers/{customerId}")
    public ResponseEntity<CustomerDto> fetchCustomerById (@PathVariable UUID customerId) {
        CustomerDto customerDto = iUserService.getCustomer(customerId);
        return ResponseEntity.status(HttpStatus.OK).body(customerDto);
    }
}
