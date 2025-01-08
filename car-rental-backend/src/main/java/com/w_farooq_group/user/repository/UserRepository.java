package com.w_farooq_group.user.repository;

import com.w_farooq_group.user.entity.Customer;
import com.w_farooq_group.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<User, UUID> {
    boolean existsByEmail (String email);
    Optional<User> findByEmail (String email);
    Optional<Customer> findCustomerById(UUID id);

}
