package com.w_farooq_group.vehicle.controller;

import com.w_farooq_group.shared.constants.AppConstants;
import com.w_farooq_group.vehicle.dto.CarDto;
import com.w_farooq_group.shared.dto.ResponseDto;
import com.w_farooq_group.vehicle.dto.VanDto;
import com.w_farooq_group.vehicle.dto.VehicleDto;
import com.w_farooq_group.vehicle.service.IVehicleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/vehicles", produces = {MediaType.APPLICATION_JSON_VALUE})
public class VehicleController {

    private static final Logger log = LoggerFactory.getLogger(VehicleController.class);

    private final IVehicleService iVehicleService;

    public VehicleController(IVehicleService iVehicleService) {
        this.iVehicleService = iVehicleService;
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/car/create")
    public ResponseEntity<ResponseDto> createCar (@RequestParam String type, @RequestBody CarDto carDto) {
        log.info("new Car create request with reg :  {}", carDto.getReg());
        iVehicleService.createVehicle(type, carDto);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(new ResponseDto(AppConstants.STATUS_201, AppConstants.MESSAGE_201));
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/van/create")
    public ResponseEntity<ResponseDto> createVan (@RequestParam String type, @RequestBody VanDto vanDto) {
        log.info("new Van create request with reg :  {}", vanDto.getReg());
        iVehicleService.createVehicle(type, vanDto);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(new ResponseDto(AppConstants.STATUS_201, AppConstants.MESSAGE_201));
    }


    @GetMapping("/fetch/{reg}")
    public ResponseEntity<?> fetchVehicleByReg (@PathVariable String reg) {
        log.info("Vehicle with reg {} fetch request", reg);
        VehicleDto vehicleDto = iVehicleService.fetchVehicleByReg(reg);
        return ResponseEntity.status(HttpStatus.OK).body(vehicleDto);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/update/{reg}")
    public ResponseEntity<ResponseDto> updateVehicle (@PathVariable String reg, @RequestBody VehicleDto vehicleDto) {
        log.info("vehicle with reg {} update request", vehicleDto.getReg());
        boolean isUpdated = iVehicleService.updateVehicle(reg, vehicleDto);
        return isUpdated ? ResponseEntity.status(HttpStatus.OK).body(new ResponseDto(AppConstants.STATUS_200, AppConstants.STATUS_200)) :
                ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseDto(AppConstants.STATUS_417, AppConstants.MESSAGE_417_UPDATE));
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/delete/{reg}")
    public ResponseEntity<ResponseDto> deleteVehicle (@PathVariable String reg) {
        log.info("delete request for vehicle with reg {}", reg);
        boolean isDeleted = iVehicleService.deleteVehicle(reg);
        return isDeleted ? ResponseEntity.status(HttpStatus.OK).body(new ResponseDto(AppConstants.STATUS_200, AppConstants.STATUS_200)) :
                ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseDto(AppConstants.STATUS_417, AppConstants.MESSAGE_417_DELETE));
    }

    @GetMapping("/fetch/cars")
    public ResponseEntity<List<CarDto>> fetchAllCars () {
        log.info("fetch request for all cars");
        List<CarDto> allCars = iVehicleService.getAllCars();
        return ResponseEntity.status(HttpStatus.OK).body(allCars);
    }
}
