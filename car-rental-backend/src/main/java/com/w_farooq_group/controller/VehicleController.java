package com.w_farooq_group.controller;

import com.w_farooq_group.constants.AppConstants;
import com.w_farooq_group.dto.CarDto;
import com.w_farooq_group.dto.ResponseDto;
import com.w_farooq_group.dto.VanDto;
import com.w_farooq_group.dto.VehicleDto;
import com.w_farooq_group.service.IVehicleService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/v1/vehicles", produces = {MediaType.APPLICATION_JSON_VALUE})
public class VehicleController {

    private final IVehicleService iVehicleService;

    public VehicleController(IVehicleService iVehicleService) {
        this.iVehicleService = iVehicleService;
    }

    @PostMapping("/car/create")
    public ResponseEntity<ResponseDto> createCar (@RequestParam String type, @RequestBody CarDto carDto) {
        iVehicleService.createVehicle(type, carDto);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(new ResponseDto(AppConstants.STATUS_201, AppConstants.MESSAGE_201));
    }

    @PostMapping("/van/create")
    public ResponseEntity<ResponseDto> createVan (@RequestParam String type, @RequestBody VanDto vanDto) {
        iVehicleService.createVehicle(type, vanDto);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(new ResponseDto(AppConstants.STATUS_201, AppConstants.MESSAGE_201));
    }


    @GetMapping("/fetch/{reg}")
    public ResponseEntity<?> fetchVehicleByReg (@PathVariable String reg) {
        VehicleDto vehicleDto = iVehicleService.fetchVehicleByReg(reg);
        return ResponseEntity.status(HttpStatus.OK).body(vehicleDto);
    }

    @PutMapping("/update/{reg}")
    public ResponseEntity<ResponseDto> updateVehicle (@PathVariable String reg, @RequestBody VehicleDto vehicleDto) {
        boolean isUpdated = iVehicleService.updateVehicle(reg, vehicleDto);
        return isUpdated ? ResponseEntity.status(HttpStatus.OK).body(new ResponseDto(AppConstants.STATUS_200, AppConstants.STATUS_200)) :
                ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseDto(AppConstants.STATUS_417, AppConstants.MESSAGE_417_UPDATE));
    }

    @PutMapping("/delete/{reg}")
    public ResponseEntity<ResponseDto> updateVehicle (@PathVariable String reg) {
        boolean isDeleted = iVehicleService.deleteVehicle(reg);
        return isDeleted ? ResponseEntity.status(HttpStatus.OK).body(new ResponseDto(AppConstants.STATUS_200, AppConstants.STATUS_200)) :
                ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseDto(AppConstants.STATUS_417, AppConstants.MESSAGE_417_DELETE));
    }
}
