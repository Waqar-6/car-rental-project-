package com.w_farooq_group.service.impl;

import com.w_farooq_group.dto.CarDto;
import com.w_farooq_group.dto.VanDto;
import com.w_farooq_group.dto.VehicleDto;
import com.w_farooq_group.entity.Car;
import com.w_farooq_group.entity.Van;
import com.w_farooq_group.entity.Vehicle;
import com.w_farooq_group.exception.ResourceAlreadyExistsException;
import com.w_farooq_group.exception.ResourceNotFoundException;
import com.w_farooq_group.factory.VehicleFactory;
import com.w_farooq_group.mapper.VehicleMapper;
import com.w_farooq_group.repository.VehicleRepository;
import com.w_farooq_group.service.IVehicleService;
import org.springframework.stereotype.Service;

@Service
public class VehicleServiceImpl implements IVehicleService {

    private final VehicleRepository vehicleRepository;
    private final VehicleFactory vehicleFactory;

    public VehicleServiceImpl(VehicleRepository vehicleRepository, VehicleFactory vehicleFactory) {
        this.vehicleRepository = vehicleRepository;
        this.vehicleFactory = vehicleFactory;
    }


    @Override
    public <T extends VehicleDto> void  createVehicle(String type, T vehicleDto) {
        String reg = vehicleDto.getReg();
        boolean alreadyExists = vehicleRepository.existsByReg(reg);
        if (alreadyExists) throw new ResourceAlreadyExistsException(type, "reg", reg);
        Vehicle newVehicle = vehicleFactory.createVehicle(type, vehicleDto);
        vehicleRepository.save(newVehicle);
    }

    @Override
    public VehicleDto fetchVehicleByReg(String reg) {
        Vehicle vehicle = vehicleRepository.findByReg(reg).orElseThrow(() -> new ResourceNotFoundException("Vehicle", "reg", reg));
        if (vehicle instanceof Car car) return VehicleMapper.mapToCarDto(car, new CarDto());
        if (vehicle instanceof Van van) return VehicleMapper.mapToVanDto(van, new VanDto());
        return null;
    }

    @Override
    public <T extends VehicleDto> boolean updateVehicle(String reg, T vehicleDto) {
        Vehicle vehicle = vehicleRepository.findByReg(reg).orElseThrow(() -> new ResourceNotFoundException("Vehicle", "reg", reg));
        if(vehicleDto instanceof CarDto carDto ) VehicleMapper.mapToCar(carDto, (Car) vehicle);
        if (vehicleDto instanceof VanDto vanDto) VehicleMapper.mapToVan(vanDto, (Van) vehicle);
        vehicleRepository.save(vehicle);
        return true;
    }

    @Override
    public boolean deleteVehicle(String reg) {
        Vehicle vehicle = vehicleRepository.findByReg(reg).orElseThrow(() -> new ResourceNotFoundException("Vehicle", "reg", reg));
        vehicleRepository.delete(vehicle);
        return true;
    }
}
