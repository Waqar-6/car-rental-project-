package com.w_farooq_group.rentalrecord.controller;

import com.w_farooq_group.rentalrecord.dto.RentalRecordDto;
import com.w_farooq_group.rentalrecord.request.RentalRecordRequest;
import com.w_farooq_group.rentalrecord.service.IRentalRecordService;
import com.w_farooq_group.shared.constants.AppConstants;
import com.w_farooq_group.shared.dto.ResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(value = "/api/v1/records", produces = {MediaType.APPLICATION_JSON_VALUE})
public class RentalRecordController {

    private final IRentalRecordService iRentalRecordService;

    public RentalRecordController(IRentalRecordService iRentalRecordService) {
        this.iRentalRecordService = iRentalRecordService;
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/create")
    public ResponseEntity<ResponseDto> createRentalRecord (@RequestBody RentalRecordRequest request) {
        iRentalRecordService.createRental(request);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(new ResponseDto(AppConstants.STATUS_201, AppConstants.MESSAGE_201));
    }

    @GetMapping("/fetch/{rentalId}")
    public ResponseEntity<RentalRecordDto> fetchRecordById (@PathVariable UUID rentalId) {
        RentalRecordDto rentalRecordDto = iRentalRecordService.getRentalById(rentalId);
        return new ResponseEntity<>(rentalRecordDto, HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/fetch")
    public ResponseEntity<List<RentalRecordDto>> getAllRentals () {
        List<RentalRecordDto> allRentals = iRentalRecordService.getAllRentals();
        return new ResponseEntity<>(allRentals, HttpStatus.OK);
    }

    @PreAuthorize("hasRole('CUSTOMER')")
    @GetMapping("/fetch/{customerId}")
    public ResponseEntity<List<RentalRecordDto>> fetchByCustomerId (@PathVariable UUID customerId) {
        List<RentalRecordDto> customerRentals = iRentalRecordService.getCustomerRentals(customerId);
        return new ResponseEntity<>(customerRentals, HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/fetch/{vehicleId}")
    public ResponseEntity<List<RentalRecordDto>> fetchVehicleRentals (@PathVariable UUID vehicleId) {
        List<RentalRecordDto> vehicleRentals = iRentalRecordService.getVehicleRentals(vehicleId);
        return new ResponseEntity<>(vehicleRentals, HttpStatus.OK);
    }


}
