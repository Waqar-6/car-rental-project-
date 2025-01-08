package com.w_farooq_group.user.dto;

import com.w_farooq_group.rentalrecord.dto.RentalRecordDto;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.UUID;

public class CustomerDto extends UserDto{
    private LocalDate dob;
    private String address;
    private String drivingLicenceNumber;
    private List<RentalRecordDto> rentalRecords;

    public CustomerDto(UUID id,String firstName, String lastName, HashSet<String> roles, String email, LocalDate dob, String address, String drivingLicenceNumber, List<RentalRecordDto> rentalRecords) {
        super(id,firstName, lastName, roles, email);
        this.dob = dob;
        this.address = address;
        this.drivingLicenceNumber = drivingLicenceNumber;
        this.rentalRecords = rentalRecords;
    }

    public CustomerDto () {}

    public List<RentalRecordDto> getRentalRecords() {
        return rentalRecords;
    }

    public void setRentalRecords(List<RentalRecordDto> rentalRecords) {
        this.rentalRecords = rentalRecords;
    }

    public LocalDate getDob() {return dob;}

    public void setDob(LocalDate dob) {this.dob = dob;}

    public String getAddress() {return address;}

    public void setAddress(String address) {this.address = address;}

    public String getDrivingLicenceNumber() {return drivingLicenceNumber;}

    public void setDrivingLicenceNumber(String drivingLicenceNumber) {this.drivingLicenceNumber = drivingLicenceNumber;}
}
