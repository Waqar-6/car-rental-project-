package com.w_farooq_group.user.requests;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.HashSet;

//@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type")
//@JsonSubTypes({
//        @JsonSubTypes.Type(value = CustomerRegistrationRequest.class, name = "customer")
//})

public class UserRegistrationRequest {
    @NotNull(message = "first name can not be empty")
    @Size(min = 3, message = "first name can not be less then 3 characters")
    private String firstName;
    @NotNull(message = "last name can not be empty")
    @Size(min = 3, message = "last name can not be less then 3 characters")
    private String lastName;
    private HashSet<String> roles;
    @NotNull(message = "email can not be empty")
    @Email(message = "email has to be valid")
    private String email;
    @NotNull(message = "password can not be empty")
    @Size(min = 5, message = "password can not be less then 5 characters")
    private String password;

    public UserRegistrationRequest(String firstName, String lastName, HashSet<String> roles, String email, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.roles = roles;
        this.email = email;
        this.password = password;
    }

    public UserRegistrationRequest() {}

    public @NotNull(message = "first name can not be empty") @Size(min = 3, message = "first name can not be less then 3 characters") String getFirstName() {
        return firstName;
    }

    public void setFirstName(@NotNull(message = "first name can not be empty") @Size(min = 3, message = "first name can not be less then 3 characters") String firstName) {
        this.firstName = firstName;
    }

    public @NotNull(message = "last name can not be empty") @Size(min = 3, message = "last name can not be less then 3 characters") String getLastName() {
        return lastName;
    }

    public void setLastName(@NotNull(message = "last name can not be empty") @Size(min = 3, message = "last name can not be less then 3 characters") String lastName) {
        this.lastName = lastName;
    }

    public HashSet<String> getRoles() {
        return roles;
    }

    public void setRoles(HashSet<String> roles) {
        this.roles = roles;
    }

    public @NotNull(message = "email can not be empty") @Email(message = "email has to be valid") String getEmail() {
        return email;
    }

    public void setEmail(@NotNull(message = "email can not be empty") @Email(message = "email has to be valid") String email) {
        this.email = email;
    }

    public @NotNull(message = "password can not be empty") @Size(min = 5, message = "password can not be less then 5 characters") String getPassword() {
        return password;
    }

    public void setPassword(@NotNull(message = "password can not be empty") @Size(min = 5, message = "password can not be less then 5 characters") String password) {
        this.password = password;
    }
}
