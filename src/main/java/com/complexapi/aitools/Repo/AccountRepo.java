package com.complexapi.aitools.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.complexapi.aitools.Entity.Account;

@Repository
public interface AccountRepo extends JpaRepository<Account, Long> {

    
} 
