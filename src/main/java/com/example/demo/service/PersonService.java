package com.example.demo.service;

import com.example.demo.database.PersonDB;
import com.example.demo.model.Person;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class PersonService {

    private final PersonDB personDB;

    @Autowired
    public PersonService(@Qualifier("Person Database") PersonDB personDB) {
        this.personDB = personDB;
    }
    // public PersonService(@Qualifier("Database : postgres, musql, sqlite, sql server") PersonDB personDB) {
    //     this.personDB = personDB;
    // }
    
    public int addPerson(Person person) {
        return personDB.insertPerson(person);
    }

    public List<Person> getAllPersons() {
        return personDB.selectAllPersons();
    }

    public Optional<Person> getPeron(UUID id) {
        return personDB.selectPeron(id);
    }

    public int deletePerson(UUID id) {
        return personDB.deletePerson(id);
    }

    public int updatePerson(UUID id, Person person) {
        return personDB.updatePerson(id, person);
    }
}
