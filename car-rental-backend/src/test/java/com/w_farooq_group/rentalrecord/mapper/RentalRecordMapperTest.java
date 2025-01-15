package com.w_farooq_group.rentalrecord.mapper;

import com.w_farooq_group.rentalrecord.dto.RentalRecordDto;
import com.w_farooq_group.rentalrecord.entity.RentalRecord;
import com.w_farooq_group.rentalrecord.enums.RentalStatus;
import com.w_farooq_group.user.entity.Customer;
import com.w_farooq_group.vehicle.entity.Van;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class RentalRecordMapperTest {

    @DisplayName("mapToRentalRecordDto")
    @Test
    void testMapToRentalRecordDto_whenGivenRentalRecordEntity () {
        // Arrange

        // Customer set up
        UUID carId = UUID.randomUUID();
        HashSet<String> roles = new HashSet<>();
        roles.add("CUSTOMER");
        Customer customer = new Customer(carId, "Alice", "Johnson", roles, "alice.johnson@example.com", "password", LocalDate.of(1990, 1, 1), "123 Main St", "DL123456");

        // Vehicle set up
        UUID vehicleId = UUID.randomUUID();
        Van vehicle = new Van(vehicleId, "Vauxhall", "Vivaro", "WM20 JDH", "Diesel", 178.20, true, true, 120);

        // Rental record setup
        UUID rentalRecordId = UUID.randomUUID();
        RentalRecord rentalRecord = new RentalRecord(
                rentalRecordId,
                customer,
                vehicle,
                LocalDateTime.of(2025, 1, 16, 10, 0),
                LocalDateTime.of(2025, 1, 29, 10, 0),
                RentalStatus.ACTIVE,
                BigDecimal.valueOf(178.20)
        );

        // Act
        RentalRecordDto rentalRecordDto = RentalRecordMapper.mapToRentalRecordDto(rentalRecord, new RentalRecordDto());

        /// Assert
        assertRentalsRecordEquals(rentalRecord, rentalRecordDto);
    }

    private void assertRentalsRecordEquals (RentalRecord expected, RentalRecordDto actual) {
        assertEquals(expected.getId(), actual.getId(),
                () -> message("Id", expected.getId(), actual.getId()));
        assertEquals(expected.getStartDateTime(), actual.getStartDateTime(),
                () -> message("Start Date Time", expected.getStartDateTime(), actual.getStartDateTime()));
        assertEquals(expected.getEndDateTime(), actual.getEndDateTime(),
                () -> message("End Date Time", expected.getEndDateTime(), actual.getEndDateTime()));
        assertEquals(expected.getStatus(), actual.getStatus(),
                () -> message("Status", expected.getStatus(), actual.getStatus()));
        assertEquals(expected.getTotalPrice(), actual.getTotalPrice(),
                () -> message("Total Price", expected.getTotalPrice(), actual.getTotalPrice()));
    }

    private <T> String message (String testFor, T expectedResult, T actualResult) {
        return "test failed for " + testFor +   " as actual result : " + actualResult + " does not equal expected result : " + expectedResult;
    }

}