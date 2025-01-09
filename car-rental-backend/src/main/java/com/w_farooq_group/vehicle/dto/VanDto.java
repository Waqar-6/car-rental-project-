package com.w_farooq_group.vehicle.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

import java.util.UUID;

public class VanDto extends VehicleDto {

    @NotEmpty(message = "has tail lift can not be empty")
    private boolean hasTailLift;
    @Size(min = 1, message = "weight limit can not be less then 1")
    private double weightLimit;

    public VanDto(UUID id, String brand, String model, String reg, String fuelType, double dailyRate, boolean isAvailable, boolean hasTailLift, double weightLimit) {
        super(id, brand, model, reg, fuelType, dailyRate, isAvailable);
        this.hasTailLift = hasTailLift;
        this.weightLimit = weightLimit;
    }

    public VanDto() {}


    @NotEmpty(message = "has tail lift can not be empty")
    public boolean isHasTailLift() {
        return hasTailLift;
    }

    public void setHasTailLift(@NotEmpty(message = "has tail lift can not be empty") boolean hasTailLift) {
        this.hasTailLift = hasTailLift;
    }

    @Size(min = 1, message = "weight limit can not be less then 1")
    public double getWeightLimit() {
        return weightLimit;
    }

    public void setWeightLimit(@Size(min = 1, message = "weight limit can not be less then 1") double weightLimit) {
        this.weightLimit = weightLimit;
    }
}
