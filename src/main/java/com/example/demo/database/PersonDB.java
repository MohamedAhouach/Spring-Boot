package com.example.demo.database;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.example.demo.model.Person;

public interface PersonDB {

    int insertPerson(UUID id, Person person);

    default int insertPerson(Person person) {
        UUID id = UUID.randomUUID();
        return insertPerson(id, person);
    }

    List<Person> selectAllPersons();

    int deletePerson(UUID id);

    int updatePerson(UUID id, Person person);

    Optional<Person> selectPeron(UUID id);
}
