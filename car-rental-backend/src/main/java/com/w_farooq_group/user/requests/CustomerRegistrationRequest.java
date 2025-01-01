package com.w_farooq_group.user.requests;

import java.time.LocalDate;
import java.util.HashSet;

public class CustomerRegistrationRequest extends UserRegistrationRequest{
    private LocalDate dob;
    private String address;
    private String drivingLicenceNumber;

    public CustomerRegistrationRequest(String firstName, String lastName, HashSet<String> roles, String email, String password, LocalDate dob, String address, String drivingLicenceNumber) {
        super(firstName, lastName, roles, email, password);
        this.dob = dob;
        this.address = address;
        this.drivingLicenceNumber = drivingLicenceNumber;
    }

    public CustomerRegistrationRequest() {}

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDrivingLicenceNumber() {
        return drivingLicenceNumber;
    }

    public void setDrivingLicenceNumber(String drivingLicenceNumber) {
        this.drivingLicenceNumber = drivingLicenceNumber;
    }
}
