package com.w_farooq_group.user.mapper;

import com.w_farooq_group.user.dto.CustomerDto;
import com.w_farooq_group.user.entity.Customer;
import com.w_farooq_group.user.requests.CustomerRegistrationRequest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class UserMapperTest {



    @DisplayName("mapRequestToEntity")
    @Test
    void testMapRequestToEntity_whenGivenEntityPassed_shouldMapAllFields() {

        // Arrange
        UUID id = UUID.randomUUID();
        HashSet<String> roles = new HashSet<>();
        roles.add("CUSTOMER");
        CustomerRegistrationRequest customerRegistrationRequest = new CustomerRegistrationRequest("Alice", "Johnson", roles, "alice.johnson@example.com", "password", LocalDate.of(1990, 1, 1),"DL123456", "123 Main St");

        // Act
        Customer mappedCustomer = UserMapper.mapRequestToEntity(customerRegistrationRequest, new Customer());


        // Assert
        asserRequestToEntityEquals(customerRegistrationRequest, mappedCustomer);
    }


    @DisplayName("mapToCustomerDto")
    @Test
    void testMapToCustomerDto_whenGivenCustomerEntity_shouldMapAllFields() {

        // Arrange
        UUID id = UUID.randomUUID();
        HashSet<String> roles = new HashSet<>();
        roles.add("CUSTOMER");
        Customer customer = new Customer(id, "Alice", "Johnson", roles, "alice.johnson@example.com", "password", LocalDate.of(1990, 1, 1), "123 Main St", "DL123456");
        // Act
        CustomerDto mappedDto = UserMapper.mapToCustomerDto(customer, new CustomerDto());

        // Assert
        assertCustomerEntityToCustomerDtoEquals(customer, mappedDto);
    }


    @DisplayName("mapToCustomer")
    @Test
    void testMapToCustomer_whenGivenCustomerDto_shouldMapAllFields() {

        // Arrange
        UUID id = UUID.randomUUID();
        HashSet<String> roles = new HashSet<>();
        roles.add("CUSTOMER");
        CustomerDto customerDto = new CustomerDto(id, "Alice", "Johnson", roles, "alice.johnson@example.com", LocalDate.of(1990, 1, 1), "123 Main St", "DL123456", List.of());

        // Act
        Customer mappedCustomer = UserMapper.mapToCustomer(customerDto, new Customer());

        // Assert
        asserCustomerDtoToCustomerEntityEquals(customerDto, mappedCustomer);

    }



    private void asserRequestToEntityEquals (CustomerRegistrationRequest expected, Customer actual) {
        assertEquals(expected.getFirstName(), actual.getFirstName(), () -> message("Firstname", expected.getFirstName(), actual.getFirstName()));
        assertEquals(expected.getLastName(), actual.getLastName(), () -> message("Lastname", expected.getLastName(), actual.getLastName()));
        assertEquals(expected.getEmail(), actual.getEmail(), () -> message("Email", expected.getEmail(), actual.getEmail()));
        assertEquals(expected.getRoles(), actual.getRoles(), () -> message("Roles", expected.getRoles(), actual.getRoles()));
        assertEquals(expected.getPassword(), actual.getPassword(), () -> message("Password", expected.getPassword(), actual.getPassword()));
        assertEquals(expected.getDob(), actual.getDob(), () -> message("Date of birth", expected.getDob(), actual.getDob()));
        assertEquals(expected.getAddress(), actual.getAddress(), () -> message("Address", expected.getAddress(), actual.getAddress()));
        assertEquals(expected.getDrivingLicenceNumber(), actual.getDrivingLicenceNumber(), () -> message("DrivingLicenceNumber", expected.getDrivingLicenceNumber(), actual.getDrivingLicenceNumber()));
    }

    private void assertCustomerEntityToCustomerDtoEquals(Customer expected, CustomerDto actual) {
        assertEquals(expected.getId(), actual.getId(), () -> message("id", expected.getId(), actual.getId()));
        assertEquals(expected.getFirstName(), actual.getFirstName(), () -> message("Firstname", expected.getFirstName(), actual.getFirstName()));
        assertEquals(expected.getLastName(), actual.getLastName(), () -> message("Lastname", expected.getLastName(), actual.getLastName()));
        assertEquals(expected.getEmail(), actual.getEmail(), () -> message("Email", expected.getEmail(), actual.getEmail()));
        assertEquals(expected.getRoles(), actual.getRoles(), () -> message("Roles", expected.getRoles(), actual.getRoles()));
        assertEquals(expected.getDob(), actual.getDob(), () -> message("Date of birth", expected.getDob(), actual.getDob()));
        assertEquals(expected.getDrivingLicenceNumber(), actual.getDrivingLicenceNumber(), () -> message("DrivingLicenceNumber", expected.getDrivingLicenceNumber(), actual.getDrivingLicenceNumber()));
    }

    private void asserCustomerDtoToCustomerEntityEquals (CustomerDto expected, Customer actual) {
        assertEquals(expected.getFirstName(), actual.getFirstName(), () -> message("Firstname", expected.getFirstName(), actual.getFirstName()));
        assertEquals(expected.getLastName(), actual.getLastName(), () -> message("Lastname", expected.getLastName(), actual.getLastName()));
        assertEquals(expected.getEmail(), actual.getEmail(), () -> message("Email", expected.getEmail(), actual.getEmail()));
        assertEquals(expected.getRoles(), actual.getRoles(), () -> message("Roles", expected.getRoles(), actual.getRoles()));
        assertEquals(expected.getDob(), actual.getDob(), () -> message("Date of birth", expected.getDob(), actual.getDob()));
        assertEquals(expected.getDrivingLicenceNumber(), actual.getDrivingLicenceNumber(), () -> message("DrivingLicenceNumber", expected.getDrivingLicenceNumber(), actual.getDrivingLicenceNumber()));
    }

    private <T> String message (String testFor, T expectedResult, T actualResult) {
        return "test failed for " + testFor +   " as actual result : " + actualResult + " does not equal expected result : " + expectedResult;
    }
}