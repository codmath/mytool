package com.complexapi.aitools.Repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.complexapi.aitools.Entity.MoneyTransaction;
@Repository
public interface MoneyTransactionRepo extends JpaRepository<MoneyTransaction, Long>{
 @Query(value="SELECT h.transactionAmount FROM MoneyTransaction h WHERE h.transactionType=:transactionType AND h.personId=:personId")
List<Double> findDepositMoney(@Param("transactionType") String transactionType,  @Param("personId") Long personId );
    
} 