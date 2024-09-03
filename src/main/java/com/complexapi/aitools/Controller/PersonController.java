package com.complexapi.aitools.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.complexapi.aitools.Entity.Person;
import com.complexapi.aitools.Service.PersonService;

@RestController
@RequestMapping("/api/person")
public class PersonController {
    @Autowired
    private PersonService personService;
    @PostMapping("/insert")
    public ResponseEntity<String> uploadPersonData(@RequestBody Person person){
        return ResponseEntity.ok( personService.addPersonData(person));
    }

    @GetMapping("/getBalance/{personId}")
    public ResponseEntity<Double> getBalance(@PathVariable Long personId){
        return ResponseEntity.ok(personService.findBalanace(personId));
    }



}
