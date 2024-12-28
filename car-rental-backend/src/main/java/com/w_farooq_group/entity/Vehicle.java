package com.w_farooq_group.entity;

import jakarta.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private Long id;
    private String brand;
    private String model;
    private String reg;
    private String fuelType;
    private String dailyRate;
    private boolean isAvailable;

    public Vehicle(Long id, String brand, String model, String reg, String fuelType, String dailyRate, boolean isAvailable) {
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.reg = reg;
        this.fuelType = fuelType;
        this.dailyRate = dailyRate;
        this.isAvailable = isAvailable;
    }

    public Vehicle () {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public String getDailyRate() {
        return dailyRate;
    }

    public void setDailyRate(String dailyRate) {
        this.dailyRate = dailyRate;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }
}
