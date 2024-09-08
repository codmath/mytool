package com.complexapi.aitools.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.complexapi.aitools.Entity.BeneficiaryPeople;
@Repository
public interface ReceivingRepo extends JpaRepository<BeneficiaryPeople, Long> {
    
} 