package com.w_farooq_group.vehicle.service;

import com.w_farooq_group.vehicle.dto.CarDto;
import com.w_farooq_group.vehicle.dto.VehicleDto;

import java.util.List;

public interface IVehicleService {


    <T extends VehicleDto> void createVehicle (String type , T vehicleDto);

    VehicleDto fetchVehicleByReg (String reg);

    <T extends VehicleDto> boolean updateVehicle (String reg,T vehicleDto);

    boolean deleteVehicle (String reg);

    List<CarDto> getAllCars ();


}
