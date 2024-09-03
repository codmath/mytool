package com.complexapi.aitools.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.complexapi.aitools.Entity.MoneyTransaction;
import com.complexapi.aitools.Service.MoneyService;

@RestController
@RequestMapping("/api/money")
public class MoneyController {
    @Autowired
    private MoneyService moneyService;
    @PostMapping("/insert")
    public ResponseEntity<String> uploadingMoney(@RequestBody  MoneyTransaction moneyTransaction){
        return ResponseEntity.ok(moneyService.inserting(moneyTransaction));
    }


}
