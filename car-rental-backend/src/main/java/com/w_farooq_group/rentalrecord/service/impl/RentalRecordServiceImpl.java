package com.w_farooq_group.rentalrecord.service.impl;

import com.w_farooq_group.rentalrecord.dto.RentalRecordDto;
import com.w_farooq_group.rentalrecord.entity.RentalRecord;
import com.w_farooq_group.rentalrecord.enums.RentalStatus;
import com.w_farooq_group.rentalrecord.mapper.RentalRecordMapper;
import com.w_farooq_group.rentalrecord.repository.RentalRecordRepository;
import com.w_farooq_group.rentalrecord.request.RentalRecordRequest;
import com.w_farooq_group.rentalrecord.service.IRentalRecordService;
import com.w_farooq_group.shared.exception.ResourceNotFoundException;
import com.w_farooq_group.user.dto.CustomerDto;
import com.w_farooq_group.user.entity.Customer;

import com.w_farooq_group.user.mapper.UserMapper;
import com.w_farooq_group.user.repository.UserRepository;
import com.w_farooq_group.vehicle.dto.CarDto;

import com.w_farooq_group.vehicle.entity.Car;
import com.w_farooq_group.vehicle.entity.Vehicle;
import com.w_farooq_group.vehicle.mapper.VehicleMapper;
import com.w_farooq_group.vehicle.repository.VehicleRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.UUID;

@Service
public class RentalRecordServiceImpl implements IRentalRecordService {

    private final RentalRecordRepository rentalRecordRepository;
    private final VehicleRepository vehicleRepository;
    private final UserRepository userRepository;

    public RentalRecordServiceImpl(RentalRecordRepository rentalRecordRepository, VehicleRepository vehicleRepository, UserRepository userRepository) {
        this.rentalRecordRepository = rentalRecordRepository;
        this.vehicleRepository = vehicleRepository;
        this.userRepository = userRepository;
    }

    @Override
    public void createRental(RentalRecordRequest request) {
        RentalRecord rentalRecord = createNewRentalRecord(request);
        rentalRecordRepository.save(rentalRecord);
    }

    @Override
    public RentalRecordDto getRentalById(UUID id) {
        RentalRecord rentalRecord = rentalRecordRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Rental Record", "id", id.toString()));
        CustomerDto customerDto = UserMapper.mapToCustomerDto(rentalRecord.getCustomer(), new CustomerDto());
        Vehicle vehicle = vehicleRepository.findById(rentalRecord.getVehicle().getId()).orElseThrow(() -> new ResourceNotFoundException("Vehicle", "id", rentalRecord.getVehicle().getId().toString()));
        RentalRecordDto rentalRecordDto = new RentalRecordDto();
        if (vehicle instanceof Car car){
            rentalRecordDto.setCustomerDto(customerDto);
            rentalRecordDto.setVehicleDto(VehicleMapper.mapToCarDto(car, new CarDto()));
        }
        return RentalRecordMapper.mapToRentalRecordDto(rentalRecord, rentalRecordDto);
    }

    @Override
    public List<RentalRecordDto> getAllRentals() {

        List<RentalRecord> allRecords = rentalRecordRepository.findAll();

        return allRecords.stream().map(record -> {
            RentalRecordDto rentalRecordDto = RentalRecordMapper.mapToRentalRecordDto(record, new RentalRecordDto());
            Customer customer = userRepository.findCustomerById(record.getCustomer().getId()).orElseThrow(() -> new ResourceNotFoundException("Customer", "id",record.getCustomer().getId().toString() ));
            Vehicle vehicle = vehicleRepository.findById(record.getVehicle().getId()).orElseThrow(() -> new ResourceNotFoundException("Vehicle", "id", record.getVehicle().getId().toString()));

            rentalRecordDto.setCustomerDto(UserMapper.mapToCustomerDto(customer, new CustomerDto()));
            if (vehicle instanceof Car car) rentalRecordDto.setVehicleDto(VehicleMapper.mapToCarDto(car, new CarDto()));

            return rentalRecordDto;

        }).toList();
    }

    @Override
    public List<RentalRecordDto> getCustomerRentals(UUID customerId) {
        Customer customer = userRepository.findCustomerById(customerId)
                .orElseThrow(() -> new ResourceNotFoundException("Customer", "id", customerId.toString()));
        List<RentalRecord> rentalRecords = customer.getRecords();
        return rentalRecords.stream()
                .map(record -> RentalRecordMapper.mapToRentalRecordDto(record, new RentalRecordDto())).toList();
    }

    @Override
    public List<RentalRecordDto> getVehicleRentals(UUID vehicleId) {
        Vehicle vehicle = vehicleRepository.findById(vehicleId).orElseThrow(() -> new ResourceNotFoundException("Vehicle", "id", vehicleId.toString()));

        if (vehicle instanceof Car car) {
            List<RentalRecord> rentalRecords = car.getRentals();
            return rentalRecords.stream()
                    .map(record -> RentalRecordMapper.mapToRentalRecordDto(record, new RentalRecordDto())).toList();
        }

        return List.of();
    }

    private RentalRecord createNewRentalRecord (RentalRecordRequest request) {
        Customer customer = userRepository.findCustomerById(request.getCustomerId()).orElseThrow(() -> new ResourceNotFoundException("User", "id", request.getCustomerId().toString()));
        Vehicle vehicle = vehicleRepository.findById(request.getVehicleId()).orElseThrow(() -> new ResourceNotFoundException("Vehicle", "id", request.getVehicleId().toString()));
        RentalRecord newRecord = new RentalRecord();
        newRecord.setCustomer(customer);
        newRecord.setVehicle(vehicle);
        newRecord.setStartDateTime(request.getStartDateTime());
        newRecord.setEndDateTime(request.getEndDateTime());
        newRecord.setStatus(RentalStatus.ACTIVE);

        //
        vehicle.setAvailable(false);
        vehicleRepository.save(vehicle);

        long days = ChronoUnit.DAYS.between(
                request.getStartDateTime().toLocalDate(),
                request.getEndDateTime().toLocalDate()
        );
        BigDecimal dailyRate = BigDecimal.valueOf(vehicle.getDailyRate());
        BigDecimal totalPrice =  dailyRate.multiply(BigDecimal.valueOf(days));
        newRecord.setTotalPrice(totalPrice);
        return newRecord;

    }
}
