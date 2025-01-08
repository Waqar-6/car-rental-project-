package com.w_farooq_group.rentalrecord.repository;

import com.w_farooq_group.rentalrecord.entity.RentalRecord;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface RentalRecordRepository extends JpaRepository<RentalRecord, UUID> {
}
