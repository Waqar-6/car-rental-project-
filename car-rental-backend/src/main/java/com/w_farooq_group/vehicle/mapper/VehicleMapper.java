package com.w_farooq_group.vehicle.mapper;

import com.w_farooq_group.vehicle.dto.CarDto;
import com.w_farooq_group.vehicle.dto.VanDto;
import com.w_farooq_group.vehicle.dto.VehicleDto;
import com.w_farooq_group.vehicle.entity.Car;
import com.w_farooq_group.vehicle.entity.Van;
import com.w_farooq_group.vehicle.entity.Vehicle;

public final class VehicleMapper {

    private VehicleMapper () {}


    // Entity to Dto

    public static VehicleDto mapToVehicleDto (Vehicle vehicle, VehicleDto vehicleDto) {
        vehicleDto.setBrand(vehicle.getBrand());
        vehicleDto.setModel(vehicle.getModel());
        vehicleDto.setReg(vehicle.getReg());
        vehicleDto.setDailyRate(vehicle.getDailyRate());
        vehicleDto.setAvailable(vehicle.isAvailable());
        vehicleDto.setFuelType(vehicle.getFuelType());
        return vehicleDto;
    }

    public static CarDto mapToCarDto (Car car, CarDto carDto) {
        mapToVehicleDto(car, carDto);
        carDto.setNumDoors(car.getNumDoors());
        carDto.setClassCategory(car.getClassCategory());
        return carDto;
    }

    public static VanDto mapToVanDto (Van van, VanDto vanDto) {
        mapToVehicleDto(van, vanDto);
        vanDto.setHasTailLift(van.isHasTailLift());
        vanDto.setWeightLimit(van.getWeightLimit());
        return vanDto;
    }

    // Dto to Entity

    public static Vehicle mapToVehicle (VehicleDto vehicleDto, Vehicle vehicle) {
        vehicle.setBrand(vehicleDto.getBrand());
        vehicle.setModel(vehicleDto.getModel());
        vehicle.setReg(vehicleDto.getReg());
        vehicle.setDailyRate(vehicleDto.getDailyRate());
        vehicle.setAvailable(vehicleDto.isAvailable());
        vehicle.setFuelType(vehicleDto.getFuelType());
        return vehicle;
    }

    public static Car mapToCar (CarDto carDto, Car car) {
        mapToVehicle(carDto, car);
        car.setNumDoors(carDto.getNumDoors());
        car.setClassCategory(carDto.getClassCategory());
        return car;
    }

    public static Van mapToVan (VanDto vanDto, Van van) {
        mapToVehicle(vanDto, van);
        van.setHasTailLift(vanDto.isHasTailLift());
        van.setWeightLimit(vanDto.getWeightLimit());
        return van;
    }
}
