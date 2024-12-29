package com.w_farooq_group.vehicle.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

public class CarDto extends VehicleDto {

    @NotEmpty(message = "number of doors can not be empty")
    @Size(min = 2, message = "number of doors can not be less then 2")
    private byte numDoors;
    @NotEmpty(message = "class category can not be empty has to be one of eg: SUV, SALOON, HATCHBACK")
    private String classCategory;

    public CarDto(String brand, String model, String reg, String fuelType, double dailyRate, boolean isAvailable, byte numDoors, String classCategory) {
        super(brand, model, reg, fuelType, dailyRate, isAvailable);
        this.numDoors = numDoors;
        this.classCategory = classCategory;
    }

    public CarDto () {}

    @NotEmpty(message = "number of doors can not be empty")
    @Size(min = 2, message = "number of doors can not be less then 2")
    public byte getNumDoors() {
        return numDoors;
    }

    public void setNumDoors(@NotEmpty(message = "number of doors can not be empty") @Size(min = 2, message = "number of doors can not be less then 2") byte numDoors) {
        this.numDoors = numDoors;
    }

    public @NotEmpty(message = "class category can not be empty has to be one of eg: SUV, SALOON, HATCHBACK") String getClassCategory() {
        return classCategory;
    }

    public void setClassCategory(@NotEmpty(message = "class category can not be empty has to be one of eg: SUV, SALOON, HATCHBACK") String classCategory) {
        this.classCategory = classCategory;
    }
}
