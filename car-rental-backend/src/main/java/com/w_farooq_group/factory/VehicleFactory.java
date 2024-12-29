package com.w_farooq_group.factory;

import com.w_farooq_group.dto.CarDto;
import com.w_farooq_group.dto.VanDto;
import com.w_farooq_group.dto.VehicleDto;
import com.w_farooq_group.entity.Car;
import com.w_farooq_group.entity.Van;
import com.w_farooq_group.entity.Vehicle;
import com.w_farooq_group.mapper.VehicleMapper;
import org.springframework.stereotype.Component;

@Component
public class VehicleFactory {

    public  <T extends VehicleDto> Vehicle createVehicle (String type, T vehicleDto) {
        switch (type) {
            case "car": if(vehicleDto instanceof CarDto carDto) return VehicleMapper.mapToCar(carDto, new Car());
            case "van": if (vehicleDto instanceof VanDto vanDto) return VehicleMapper.mapToVan(vanDto, new Van());
        }
        return null;
    }
}
