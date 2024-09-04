package com.complexapi.aitools.Repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.complexapi.aitools.Entity.HistoryTransaction;
@Repository
public interface  HistoryTransactionRepo extends JpaRepository<HistoryTransaction, Long> {
    @Query(value="SELECT h.totalAmountDeposit FROM HistoryTransaction h WHERE h.countAmountDeposit = :countDeposit")
    List<Double> findAccountMoney(int countDeposit);


}
