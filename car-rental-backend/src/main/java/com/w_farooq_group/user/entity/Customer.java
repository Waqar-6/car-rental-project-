package com.w_farooq_group.user.entity;

import com.w_farooq_group.rentalrecord.entity.RentalRecord;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrimaryKeyJoinColumn;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.UUID;

@Entity
@PrimaryKeyJoinColumn(name = "customer_id")
public class Customer extends User{
    private LocalDate dob;
    private String address;
    private String drivingLicenceNumber;
    @OneToMany(mappedBy = "customer")
    private List<RentalRecord> records;
    public Customer(UUID id, String firstName, String lastName, HashSet<String> roles, String email, String password, LocalDate dob, String address, String drivingLicenceNumber) {
        super(id, firstName, lastName, roles, email, password);
        this.dob = dob;
        this.address = address;
        this.drivingLicenceNumber = drivingLicenceNumber;
    }


    public Customer() {}

    public LocalDate getDob() {return dob;}

    public void setDob(LocalDate dob) {this.dob = dob;}

    public String getAddress() {return address;}

    public void setAddress(String address) {this.address = address;}

    public String getDrivingLicenceNumber() {return drivingLicenceNumber;}

    public void setDrivingLicenceNumber(String drivingLicenceNumber) {this.drivingLicenceNumber = drivingLicenceNumber;}

    public List<RentalRecord> getRecords() {
        return records;
    }

    public void setRecords(List<RentalRecord> records) {
        this.records = records;
    }
}
