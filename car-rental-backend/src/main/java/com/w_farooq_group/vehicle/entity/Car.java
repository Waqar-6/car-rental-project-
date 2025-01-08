package com.w_farooq_group.vehicle.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;

import java.util.UUID;

@Entity
@PrimaryKeyJoinColumn(name = "car_id")
public class Car extends Vehicle{
    private byte numDoors;
    private String classCategory;

    public Car(UUID id, String brand, String model, String reg, String fuelType, double dailyRate, boolean isAvailable, byte numDoors, String classCategory) {
        super(id, brand, model, reg, fuelType, dailyRate, isAvailable);
        this.numDoors = numDoors;
        this.classCategory = classCategory;
    }

    public Car() {}

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
