package com.w_farooq_group.vehicle.service.impl;

import com.w_farooq_group.vehicle.dto.CarDto;
import com.w_farooq_group.vehicle.dto.VehicleDto;
import com.w_farooq_group.vehicle.entity.Car;
import com.w_farooq_group.vehicle.entity.Vehicle;
import com.w_farooq_group.vehicle.factory.VehicleFactory;
import com.w_farooq_group.vehicle.mapper.VehicleMapper;
import com.w_farooq_group.vehicle.repository.VehicleRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class VehicleServiceImplTest {

    
    @Test
    void testCreateVehicle_whenGivenCarDto_shouldCreateCar() {

        // Arrange
        VehicleRepository vehicleRepository = Mockito.mock(VehicleRepository.class);
        VehicleFactory vehicleFactory = Mockito.mock(VehicleFactory.class);
        CarDto carDto = new CarDto(); carDto.setBrand("BMW"); carDto.setModel("5 series"); carDto.setReg("bmw22 pff"); carDto.setFuelType("petrol"); carDto.setDailyRate(120.20);
        carDto.setAvailable(true);
        carDto.setNumDoors((byte) 2);
        carDto.setClassCategory("SEDAN");

        VehicleServiceImpl vehicleService = new VehicleServiceImpl(vehicleRepository, vehicleFactory);
        Vehicle car = VehicleMapper.mapToCar(carDto, new Car());

        when(vehicleRepository.existsByReg(carDto.getReg())).thenReturn(false);

        when(vehicleFactory.createVehicle(Mockito.anyString(), Mockito.any(VehicleDto.class))).thenReturn(car);

        vehicleService.createVehicle("car", carDto);
        verify(vehicleRepository).existsByReg("bmw22 pff");

        vehicleRepository.save(car);
    }

    @Test
    void fetchVehicleByReg() {
    }

    @Test
    void updateVehicle() {
    }

    @Test
    void deleteVehicle() {
    }

    @Test
    void getAllCars() {
    }
}