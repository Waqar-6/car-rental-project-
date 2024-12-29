package com.w_farooq_group.service;

import com.w_farooq_group.dto.VehicleDto;

public interface IVehicleService {


    <T extends VehicleDto> void createVehicle (String type , T vehicleDto);

    VehicleDto fetchVehicleByReg (String reg);

    <T extends VehicleDto> boolean updateVehicle (String reg,T vehicleDto);

    boolean deleteVehicle (String reg);


}
