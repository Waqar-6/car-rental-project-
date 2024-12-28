package com.w_farooq_group.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

import java.util.UUID;

public abstract class VehicleDto {

    @NotEmpty(message = "brand can not to be empty")
    private String brand;
    @NotEmpty(message = "model can not be empty")
    private String model;
    @NotEmpty(message = "vehicle reg can not be empty")
    private String reg;
    @NotEmpty(message = "fuel type can not be empty")
    private String fuelType;
    @NotEmpty(message = "daily rate can not be empty")
    @Size(min = 1, message = "Daily rate can not be less then 1")
    private double dailyRate;
    private boolean isAvailable;

    public VehicleDto(String brand, String model, String reg, String fuelType, double dailyRate, boolean isAvailable) {
        this.brand = brand;
        this.model = model;
        this.reg = reg;
        this.fuelType = fuelType;
        this.dailyRate = dailyRate;
        this.isAvailable = isAvailable;
    }

    public VehicleDto () {}

    public @NotEmpty(message = "brand can not to be empty") String getBrand() {
        return brand;
    }

    public void setBrand(@NotEmpty(message = "brand can not to be empty") String brand) {
        this.brand = brand;
    }

    public @NotEmpty(message = "model can not be empty") String getModel() {
        return model;
    }

    public void setModel(@NotEmpty(message = "model can not be empty") String model) {
        this.model = model;
    }

    public @NotEmpty(message = "vehicle reg can not be empty") String getReg() {
        return reg;
    }

    public void setReg(@NotEmpty(message = "vehicle reg can not be empty") String reg) {
        this.reg = reg;
    }

    public @NotEmpty(message = "fuel type can not be empty") String getFuelType() {
        return fuelType;
    }

    public void setFuelType(@NotEmpty(message = "fuel type can not be empty") String fuelType) {
        this.fuelType = fuelType;
    }

    @NotEmpty(message = "daily rate can not be empty")
    @Size(min = 1, message = "Daily rate can not be less then 1")
    public double getDailyRate() {
        return dailyRate;
    }

    public void setDailyRate(@NotEmpty(message = "daily rate can not be empty") @Size(min = 1, message = "Daily rate can not be less then 1") double dailyRate) {
        this.dailyRate = dailyRate;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }
}
