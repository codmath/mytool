package com.complexapi.aitools.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.complexapi.aitools.Entity.Transfer;

@Repository

public interface TransferRepo extends JpaRepository<Transfer, Long> {

    
} 