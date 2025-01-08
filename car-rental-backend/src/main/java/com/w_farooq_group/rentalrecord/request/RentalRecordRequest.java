package com.w_farooq_group.rentalrecord.request;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;
import java.util.UUID;

public class RentalRecordRequest {
    @NotNull(message = "Customer ID can not be empty")
    private UUID customerId;
    @NotNull(message = "Customer ID can not be empty")
    private UUID vehicleId;
    @NotNull(message = "start date can not be empty")
    @Future(message = "start date can to be in the past")
    private LocalDateTime startDateTime;
    @NotNull(message = "end date can not be empty")
    @Future(message = "end date can not be in the past")
    private LocalDateTime endDateTime;

    public RentalRecordRequest(UUID customerId, UUID vehicleId, LocalDateTime startDateTime, LocalDateTime endDateTime) {
        this.customerId = customerId;
        this.vehicleId = vehicleId;
        this.startDateTime = startDateTime;
        this.endDateTime = endDateTime;
    }

    public RentalRecordRequest () {}

    public @NotNull(message = "Customer ID can not be empty") UUID getCustomerId() {
        return customerId;
    }

    public void setCustomerId(@NotNull(message = "Customer ID can not be empty") UUID customerId) {
        this.customerId = customerId;
    }

    public @NotNull(message = "Customer ID can not be empty") UUID getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(@NotNull(message = "Customer ID can not be empty") UUID vehicleId) {
        this.vehicleId = vehicleId;
    }

    public @NotNull(message = "start date can not be empty") @Future(message = "start date can to be in the past") LocalDateTime getStartDateTime() {
        return startDateTime;
    }

    public void setStartDateTime(@NotNull(message = "start date can not be empty") @Future(message = "start date can to be in the past") LocalDateTime startDateTime) {
        this.startDateTime = startDateTime;
    }

    public @NotNull(message = "end date can not be empty") @Future(message = "end date can not be in the past") LocalDateTime getEndDateTime() {
        return endDateTime;
    }

    public void setEndDateTime(@NotNull(message = "end date can not be empty") @Future(message = "end date can not be in the past") LocalDateTime endDateTime) {
        this.endDateTime = endDateTime;
    }
}
