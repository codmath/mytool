package com.complexapi.aitools.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.complexapi.aitools.Entity.Account;
import com.complexapi.aitools.Service.AccountService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/api/account")
public class AccountController {
    @Autowired
    private AccountService accountService;
    
    @PostMapping("/insert")
    public ResponseEntity<String> insertAccountDetails(@RequestBody Account account){
        return ResponseEntity.ok(accountService.accountdetailsadd(account));

    }
    @GetMapping("/getAllAccount")
    public ResponseEntity<String> getMethodName() {
        return ResponseEntity.ok(accountService.fetchAccountDetails());
    }
    @GetMapping("/getAccountOfSpecificPerson/{personId}")
    public ResponseEntity<String> getDetails(@PathVariable Long personId){
        return ResponseEntity.ok(accountService.fetchSpecificAccountDetails(personId));
    }
    
}
