package com.complexapi.aitools.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.complexapi.aitools.Entity.HistoryTransaction;
@Repository
public interface  HistoryTransactionRepo extends JpaRepository<HistoryTransaction, Long> {

}
