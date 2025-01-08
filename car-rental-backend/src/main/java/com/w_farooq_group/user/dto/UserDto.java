package com.w_farooq_group.user.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.HashSet;
import java.util.UUID;

public abstract class UserDto {
    private UUID id;
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

    public UserDto(UUID id, String firstName, String lastName, HashSet<String> roles, String email) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.roles = roles;
        this.email = email;
    }

    public UserDto () {}

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

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
}
