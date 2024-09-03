package com.complexapi.aitools.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.complexapi.aitools.Entity.Person;
import com.complexapi.aitools.Repo.PersonRepo;

@Service
public class PersonService {
@Autowired
private PersonRepo personRepo;

public String addPersonData(Person person) {
    this.personRepo.save(person);
    return "successfully uploaded in my DB";
   
}

public Double findBalanace(Long personId) {
    Person person=personRepo.findById(personId).orElse(null);
    return person.getAccountBalance();

}

}
