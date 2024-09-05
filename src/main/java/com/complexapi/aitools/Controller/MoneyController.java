package com.complexapi.aitools.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.complexapi.aitools.Entity.MoneyTransaction;
import com.complexapi.aitools.Repo.MoneyTransactionRepo;
import com.complexapi.aitools.Service.MoneyService;

@RestController
@RequestMapping("/api/money")
public class MoneyController {
    @Autowired
    private MoneyService moneyService;
    @Autowired
    private MoneyTransactionRepo moneyTransactionRepo;
    @PostMapping("/insert")
    public ResponseEntity<String> uploadingMoney(@RequestBody  MoneyTransaction moneyTransaction){
        return ResponseEntity.ok(moneyService.inserting(moneyTransaction));
    }
    @GetMapping("/getAllDepositAmountBySpecificPerson")
    public ResponseEntity<String> getAllDepositAmount(){
        return ResponseEntity.ok(moneyService.getAllDepositAmount());
    }
    @GetMapping("/transaction/amount")
    public List<Double> getTotalDepositAmount(@RequestParam String transactionType, @RequestParam Long personId) {
        return moneyTransactionRepo.findDepositMoney(transactionType, personId);
    }


}
