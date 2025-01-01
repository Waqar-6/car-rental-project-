package com.w_farooq_group.user.dto;

import java.time.LocalDate;
import java.util.HashSet;

public class CustomerDto extends UserDto{
    private LocalDate dob;
    private String address;
    private String drivingLicenceNumber;

    public CustomerDto(String firstName, String lastName, HashSet<String> roles, String email, LocalDate dob, String address, String drivingLicenceNumber) {
        super(firstName, lastName, roles, email);
        this.dob = dob;
        this.address = address;
        this.drivingLicenceNumber = drivingLicenceNumber;
    }

   public CustomerDto () {}

    public LocalDate getDob() {return dob;}

    public void setDob(LocalDate dob) {this.dob = dob;}

    public String getAddress() {return address;}

    public void setAddress(String address) {this.address = address;}

    public String getDrivingLicenceNumber() {return drivingLicenceNumber;}

    public void setDrivingLicenceNumber(String drivingLicenceNumber) {this.drivingLicenceNumber = drivingLicenceNumber;}
}
