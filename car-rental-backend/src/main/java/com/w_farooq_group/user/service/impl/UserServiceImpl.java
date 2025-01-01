package com.w_farooq_group.user.service.impl;

import com.w_farooq_group.shared.exception.ResourceAlreadyExistsException;
import com.w_farooq_group.shared.exception.ResourceNotFoundException;
import com.w_farooq_group.user.dto.CustomerDto;
import com.w_farooq_group.user.dto.UserDto;
import com.w_farooq_group.user.entity.Customer;
import com.w_farooq_group.user.entity.User;
import com.w_farooq_group.user.mapper.UserMapper;
import com.w_farooq_group.user.repository.UserRepository;

import com.w_farooq_group.user.requests.CustomerRegistrationRequest;
import com.w_farooq_group.user.requests.UserRegistrationRequest;
import com.w_farooq_group.user.service.IUserService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements IUserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }


//    @Override
//    public <T extends UserDto> T getUserById(UUID id, Class<T> dtoClass) {
//        User user = userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User", "id", id.toString()));
//
//        passwordEncoder.encode(user.getPassword());
//        if (dtoClass == CustomerDto.class && user instanceof Customer customer)
//            return (T) UserMapper.mapToCustomerDto(customer, new CustomerDto());
//        return null;
//    }

    @Override
    public <T extends UserRegistrationRequest> String registerUser(T request) {

        boolean alreadyExists = userRepository.existsByEmail(request.getEmail());

        if (alreadyExists)
            throw new ResourceAlreadyExistsException("User", "email", request.getEmail());

        System.out.println("Request class: " + request.getClass().getName());


        if (request instanceof CustomerRegistrationRequest customerRequest) {
            String encodedPassword = passwordEncoder.encode(customerRequest.getPassword());
            customerRequest.setPassword(encodedPassword);


            Customer newCustomer = UserMapper.mapRequestToEntity(customerRequest, new Customer());
            userRepository.save(newCustomer);
            return "Registered";
        }
        return "not registered";
    }

    @Override
    public <T extends UserDto> boolean updateUser(String email, T userDto) {
        User userToUpdate = userRepository.findByEmail(email)
                .orElseThrow(() -> new ResourceNotFoundException("User", "email", email));

        if (userToUpdate instanceof Customer customer && userDto instanceof CustomerDto customerDto) {
            User updatedUser = UserMapper.mapToCustomer(customerDto, customer);
            userRepository.save(updatedUser);
            return true;
        }
        return false;
    }

    @Override
    public <T extends UserDto> List<T> getAllUsers(Class<T> dtoClass) {
        return userRepository.findAll().stream()
                .map(user -> {
                    if (dtoClass == CustomerDto.class && user instanceof Customer customer) {
                        return (T) UserMapper.mapToCustomerDto(customer, new CustomerDto());
                    }
                    return null;
                })
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
    }
}
