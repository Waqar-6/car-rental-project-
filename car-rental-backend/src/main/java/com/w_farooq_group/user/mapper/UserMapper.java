package com.w_farooq_group.user.mapper;

import com.w_farooq_group.user.dto.CustomerDto;
import com.w_farooq_group.user.dto.UserDto;
import com.w_farooq_group.user.entity.Customer;
import com.w_farooq_group.user.entity.User;
import com.w_farooq_group.user.requests.CustomerRegistrationRequest;


public final class UserMapper {

    private UserMapper () {}


    // Entity to Dto
    public static UserDto mapToUserDto (User user, UserDto userDto) {
        userDto.setId(user.getId());
        userDto.setFirstName(user.getFirstName());
        userDto.setLastName(user.getLastName());
        userDto.setEmail(user.getEmail());
        userDto.setRoles(user.getRoles());
        return userDto;
    }


    public static CustomerDto mapToCustomerDto (Customer customer, CustomerDto customerDto) {
        mapToUserDto(customer, customerDto);
        customerDto.setDob(customer.getDob());
        customerDto.setAddress(customerDto.getAddress());
        customerDto.setDrivingLicenceNumber(customer.getDrivingLicenceNumber());
        return customerDto;
    }


    // Dto to Entity
    public static User mapToUser (UserDto userDto, User user) {
        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        user.setEmail(userDto.getEmail());
        user.setRoles(userDto.getRoles());
        return user;
    }

    public static Customer mapToCustomer (CustomerDto customerDto, Customer customer) {
        mapToUser(customerDto, customer);
        customer.setDob(customerDto.getDob());
        customer.setAddress(customerDto.getAddress());
        customer.setDrivingLicenceNumber(customerDto.getDrivingLicenceNumber());
        return customer;
    }

    // Request to Entity
    public static Customer mapRequestToEntity(CustomerRegistrationRequest request, Customer customer) {
            customer.setFirstName(request.getFirstName());
            customer.setLastName(request.getLastName());
            customer.setRoles(request.getRoles());
            customer.setEmail(request.getEmail());
            customer.setPassword(request.getPassword());
            System.out.println(request.getPassword());
            customer.setDob(request.getDob());
            customer.setAddress(request.getAddress());
            customer.setDrivingLicenceNumber(request.getDrivingLicenceNumber());
            return customer;
    }

}
