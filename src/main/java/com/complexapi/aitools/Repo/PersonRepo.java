package com.complexapi.aitools.Repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.complexapi.aitools.Entity.Person;
@Repository
public interface PersonRepo extends JpaRepository< Person, Long>{
@Query(value="SELECT p.name FROM Person p WHERE p.accountBalance >= :balance")
List<String> findNamesFromPerson(double balance); //retrival of data from the DB

}  
