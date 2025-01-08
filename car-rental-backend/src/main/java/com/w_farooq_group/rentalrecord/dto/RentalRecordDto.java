package com.w_farooq_group.rentalrecord.dto;

import com.w_farooq_group.rentalrecord.enums.RentalStatus;
import com.w_farooq_group.user.dto.CustomerDto;
import com.w_farooq_group.vehicle.dto.VehicleDto;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

public class RentalRecordDto {
    private UUID id;
    private CustomerDto customerDto;
    private VehicleDto vehicleDto;
    private LocalDateTime startDateTime;
    private LocalDateTime endDateTime;
    private RentalStatus status;
    private BigDecimal totalPrice;

    public RentalRecordDto(UUID id, CustomerDto customerDto, VehicleDto vehicleDto, LocalDateTime startDateTime, LocalDateTime endDateTime, RentalStatus status, BigDecimal totalPrice) {
        this.id = id;
        this.customerDto = customerDto;
        this.vehicleDto = vehicleDto;
        this.startDateTime = startDateTime;
        this.endDateTime = endDateTime;
        this.status = status;
        this.totalPrice = totalPrice;
    }

    public RentalRecordDto () {}

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public CustomerDto getCustomerDto() {
        return customerDto;
    }

    public void setCustomerDto(CustomerDto customerDto) {
        this.customerDto = customerDto;
    }

    public VehicleDto getVehicleDto() {
        return vehicleDto;
    }

    public void setVehicleDto(VehicleDto vehicleDto) {
        this.vehicleDto = vehicleDto;
    }

    public LocalDateTime getStartDateTime() {
        return startDateTime;
    }

    public void setStartDateTime(LocalDateTime startDateTime) {
        this.startDateTime = startDateTime;
    }

    public LocalDateTime getEndDateTime() {
        return endDateTime;
    }

    public void setEndDateTime(LocalDateTime endDateTime) {
        this.endDateTime = endDateTime;
    }

    public RentalStatus getStatus() {
        return status;
    }

    public void setStatus(RentalStatus status) {
        this.status = status;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }
}
