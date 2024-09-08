package com.complexapi.aitools.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.stereotype.Service;

import com.complexapi.aitools.Entity.Account;
import com.complexapi.aitools.Entity.Person;
import com.complexapi.aitools.Repo.AccountRepo;
import com.complexapi.aitools.Repo.PersonRepo;

@Service
public class AccountService {
    @Autowired
    private AccountRepo accountRepo;
    @Autowired
    private PersonRepo personRepo;

    public String  accountdetailsadd(Account account) {
        Long requiredId=account.getPersonId();
        Person person=personRepo.findById(requiredId).orElse(null);
        this.accountRepo.save(account);
        System.out.println("the name of person is" + person.getName() + "he has amount of" + person.getAccountBalance());
        return "Account details updated Successfully";
    }

    public String fetchAccountDetails() {
        List<String> existingAccountNumber=accountRepo.findAccountNumber("SBI", "Barharia");
        int n =existingAccountNumber.size();
        for(int i=0; i<n; i++){
            System.out.println(existingAccountNumber.get(i));
        }
        return "successfuly able to retrive from DB ";
       
    }

    public String  fetchSpecificAccountDetails(Long personId) {
        List<String> existingAccountNumber=accountRepo.findAccountNumberSpecific("ICICI", "GKP", personId);
        int n=existingAccountNumber.size();
        System.out.println(n);
        for(int i=0; i<n; i++){
            System.out.println(existingAccountNumber.get(i));
        }
        return "specific fetched data successfully";
    }

}
