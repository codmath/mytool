package com.complexapi.aitools.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.complexapi.aitools.Entity.Account;
import com.complexapi.aitools.Service.AccountService;

@RestController
@RequestMapping("/api/account")
public class AccountController {
    @Autowired
    private AccountService accountService;
    
    @PostMapping("/insert")
    public ResponseEntity<String> insertAccountDetails(@RequestBody Account account){
        return ResponseEntity.ok(accountService.accountdetailsadd(account));

    }
}
