package com.w_farooq_group.vehicle.entity;

import com.w_farooq_group.rentalrecord.entity.RentalRecord;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String brand;
    private String model;
    private String reg;
    private String fuelType;
    private double dailyRate;
    private boolean isAvailable;
    @OneToMany(mappedBy = "vehicle")
    private List<RentalRecord> rentals;

    public Vehicle(UUID id, String brand, String model, String reg, String fuelType, double dailyRate, boolean isAvailable) {
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.reg = reg;
        this.fuelType = fuelType;
        this.dailyRate = dailyRate;
        this.isAvailable = isAvailable;
        this.rentals = new ArrayList<>();
    }

    public Vehicle () {}

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getReg() {
        return reg;
    }

    public void setReg(String reg) {
        this.reg = reg;
    }

    public String getFuelType() {
        return fuelType;
    }

    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }

    public double getDailyRate() {
        return dailyRate;
    }

    public void setDailyRate(double dailyRate) {
        this.dailyRate = dailyRate;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public List<RentalRecord> getRentals() {
        return rentals;
    }

    public void setRentals(List<RentalRecord> rentals) {
        this.rentals = rentals;
    }
}
