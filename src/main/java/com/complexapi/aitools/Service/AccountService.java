package com.complexapi.aitools.Service;

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

}
