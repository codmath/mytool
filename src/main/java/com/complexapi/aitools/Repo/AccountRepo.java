package com.complexapi.aitools.Repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.complexapi.aitools.Entity.Account;

@Repository
public interface AccountRepo extends JpaRepository<Account, Long> {
@Query(value="SELECT a.accountNumber FROM Account a WHERE a.bankName=:BankName AND a.branchName=:BranchName")
List<String> findAccountNumber(String BankName , String BranchName);
@Query(value="SELECT a.accountNumber FROM Account a WHERE a.bankName=:BankName AND a.branchName=:BranchName AND a.personId=:personId")
List<String> findAccountNumberSpecific(String BankName, String BranchName, Long personId);
@Query(value="SELECT a FROM Account a WHERE a.personId=:personId")
Optional<Account> findAccountByPersonId(Long personId);
    
} 
