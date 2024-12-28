package com.w_farooq_group.dto;

public class VanDto extends VehicleDto{

    private boolean hasTailLift;
    private double weightLimit;

    public VanDto(String brand, String model, String reg, String fuelType, double dailyRate, boolean isAvailable, boolean hasTailLift, double weightLimit) {
        super(brand, model, reg, fuelType, dailyRate, isAvailable);
        this.hasTailLift = hasTailLift;
        this.weightLimit = weightLimit;
    }


    public VanDto () {}

    public boolean isHasTailLift() {
        return hasTailLift;
    }

    public void setHasTailLift(boolean hasTailLift) {
        this.hasTailLift = hasTailLift;
    }

    public double getWeightLimit() {
        return weightLimit;
    }

    public void setWeightLimit(double weightLimit) {
        this.weightLimit = weightLimit;
    }
}
