package com.w_farooq_group.rentalrecord.service;

import com.w_farooq_group.rentalrecord.dto.RentalRecordDto;
import com.w_farooq_group.rentalrecord.request.RentalRecordRequest;

import java.util.List;
import java.util.UUID;

public interface IRentalRecordService {

    void createRental(RentalRecordRequest request);


    RentalRecordDto getRentalById(UUID id);
    List<RentalRecordDto> getAllRentals();
    List<RentalRecordDto> getCustomerRentals(UUID customerId);
    List<RentalRecordDto> getVehicleRentals(UUID vehicleId);


}
