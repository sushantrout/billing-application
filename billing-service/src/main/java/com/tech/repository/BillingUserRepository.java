package com.tech.repository;

import com.tech.model.entity.BillingUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BillingUserRepository extends JpaRepository<BillingUser, Long> {
}
