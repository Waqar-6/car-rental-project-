package com.w_farooq_group.vehicle.repository;

import com.w_farooq_group.vehicle.entity.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface VehicleRepository extends JpaRepository<Vehicle, UUID> {
    boolean existsByReg (String reg);
    Optional<Vehicle> findByReg (String reg);
}
