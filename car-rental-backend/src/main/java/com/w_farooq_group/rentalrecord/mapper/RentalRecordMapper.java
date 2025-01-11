package com.w_farooq_group.rentalrecord.mapper;

import com.w_farooq_group.rentalrecord.dto.RentalRecordDto;
import com.w_farooq_group.rentalrecord.entity.RentalRecord;

public final class RentalRecordMapper {

    private RentalRecordMapper () {}

    public static RentalRecordDto mapToRentalRecordDto (RentalRecord rentalRecord, RentalRecordDto rentalRecordDto) {
        rentalRecordDto.setId(rentalRecord.getId());
        rentalRecordDto.setStartDateTime(rentalRecord.getStartDateTime());
        rentalRecordDto.setEndDateTime(rentalRecord.getEndDateTime());
        rentalRecordDto.setTotalPrice(rentalRecord.getTotalPrice());
        rentalRecordDto.setStatus(rentalRecord.getStatus());
        return rentalRecordDto;
    }
}
