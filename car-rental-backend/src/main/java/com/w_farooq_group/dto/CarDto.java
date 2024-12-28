package com.w_farooq_group.dto;

public class CarDto extends VehicleDto{

    private byte numDoors;
    private String classCategory;

    public CarDto(String brand, String model, String reg, String fuelType, double dailyRate, boolean isAvailable, byte numDoors, String classCategory) {
        super(brand, model, reg, fuelType, dailyRate, isAvailable);
        this.numDoors = numDoors;
        this.classCategory = classCategory;
    }

    public CarDto () {}

    public byte getNumDoors() {
        return numDoors;
    }

    public void setNumDoors(byte numDoors) {
        this.numDoors = numDoors;
    }

    public String getClassCategory() {
        return classCategory;
    }

    public void setClassCategory(String classCategory) {
        this.classCategory = classCategory;
    }
}
