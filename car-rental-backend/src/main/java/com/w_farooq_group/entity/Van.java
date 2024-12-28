package com.w_farooq_group.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;

@Entity
@PrimaryKeyJoinColumn(name = "van_id")
public class Van extends Vehicle{

    private boolean hasTailLift;
    private double weightLimit;

    public Van(Long id, String brand, String model, String reg, String fuelType, String dailyRate, boolean isAvailable, boolean hasTailLift, double weightLimit) {
        super(id, brand, model, reg, fuelType, dailyRate, isAvailable);
        this.hasTailLift = hasTailLift;
        this.weightLimit = weightLimit;
    }

   public Van () {}

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
