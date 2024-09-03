package com.complexapi.aitools.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.complexapi.aitools.Entity.BeneficiaryPeople;

import com.complexapi.aitools.Repo.ReceivingRepo;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api/receivingPerson")
public class ReceivingPersonController {
    @Autowired
    private ReceivingRepo receivingRepo;
    @PostMapping("/insert")
    public String postMethodName(@RequestBody BeneficiaryPeople receivingPerson) {
        receivingRepo.save(receivingPerson);
        return "successfully uploaded in DB";
    }
    

}
