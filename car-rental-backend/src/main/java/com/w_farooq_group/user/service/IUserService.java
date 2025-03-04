package com.w_farooq_group.user.service;

import com.w_farooq_group.user.dto.CustomerDto;
import com.w_farooq_group.user.dto.UserDto;
import com.w_farooq_group.user.requests.CustomerRegistrationRequest;
import com.w_farooq_group.user.requests.UserRegistrationRequest;

import java.util.List;
import java.util.UUID;

public interface IUserService {

    <T extends UserDto> T getUserByEmail(String email, Class<T> dtoClass);
    <T extends UserRegistrationRequest> String registerUser(T request);
    <T extends UserDto> boolean updateUser(String email, T userDto);
    <T extends UserDto> List<T> getAllUsers(Class<T> dtoClass);
    List<CustomerDto> getAllCustomers ();
    CustomerDto getCustomer (UUID customerId);
}
