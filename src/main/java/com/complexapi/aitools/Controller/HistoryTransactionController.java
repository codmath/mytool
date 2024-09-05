package com.complexapi.aitools.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.complexapi.aitools.Entity.HistoryTransaction;
import com.complexapi.aitools.Service.HistoryTransactionService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/api/historyTransaction")

public class HistoryTransactionController {

    @Autowired
    private HistoryTransactionService historyTranasactionService;
    @GetMapping("/get/{personId}")
    public ResponseEntity<HistoryTransaction> getHistory(@PathVariable Long personId){
        return ResponseEntity.ok(historyTranasactionService.todohistory(personId));
    }
    @GetMapping("/getHistoryTransaction")
    public ResponseEntity<String> getMethodName() {
        return ResponseEntity.ok(historyTranasactionService.getAllHistoryTrxn());

        
    }
   
    
   

}
