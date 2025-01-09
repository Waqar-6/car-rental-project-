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

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements IUserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }


    @Override
    public <T extends UserDto> T getUserByEmail(String email, Class<T> dtoClass) {
        User user = userRepository.findByEmail(email).orElseThrow(() -> new ResourceNotFoundException("User", "id", email));
       return user instanceof Customer customer ? (T) UserMapper.mapToCustomerDto(customer, new CustomerDto()) : null;
    }

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
            System.out.println(newCustomer.getEmail() + " just registered now at: " + LocalDateTime.now());
            return "Registered";
        }

        System.out.println("registration failed at : " + LocalDateTime.now());
        return "not registered";
    }

    @Override
    public <T extends UserDto> boolean updateUser(String email, T userDto) {
        User userToUpdate = userRepository.findByEmail(email)
                .orElseThrow(() -> new ResourceNotFoundException("User", "email", email));

        if (userToUpdate instanceof Customer customer && userDto instanceof CustomerDto customerDto) {
            User updatedUser = UserMapper.mapToCustomer(customerDto, customer);
            System.out.println(updatedUser.getEmail() + " was updated at : " + LocalDateTime.now());
            userRepository.save(updatedUser);
            return true;
        }

        System.out.println(userDto.getEmail() + " failed to update at : " + LocalDateTime.now());
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

    @Override
    public List<CustomerDto> getAllCustomers() {
        return userRepository.findAll().stream()
                .filter(user -> user instanceof Customer)
                .map(user -> UserMapper.mapToCustomerDto((Customer) user, new CustomerDto())).toList();
    }

    @Override
    public CustomerDto getCustomer(UUID customerId) {
        Customer customer = userRepository.findCustomerById(customerId)
                .orElseThrow(() -> new ResourceNotFoundException("Customer", "id", customerId.toString()));
        return UserMapper.mapToCustomerDto(customer, new CustomerDto());
    }
}
