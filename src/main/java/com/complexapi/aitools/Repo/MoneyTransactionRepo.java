package com.complexapi.aitools.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.complexapi.aitools.Entity.MoneyTransaction;
@Repository
public interface MoneyTransactionRepo extends JpaRepository<MoneyTransaction, Long>{

    
} 