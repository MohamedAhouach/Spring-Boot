package com.example.demo.database;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import com.example.demo.database.PersonDB;
import com.example.demo.model.Person;
import org.springframework.stereotype.Repository;

@Repository("Person Database")
// @Repository("Database : postgres, musql, sqlite, sql server")
public class PersonDataAccessService implements PersonDB {

    private static List<Person> persons = new ArrayList<>();

    @Override
    public int insertPerson(UUID id, Person person) {
        persons.add(new Person(id, person.getName()));
        return 0;
        // return List.of(new Person(UUID.randomUUID(), "from database"));
    }

    @Override
    public List<Person> selectAllPersons() {
        return persons;
    }

    @Override
    public int deletePerson(UUID id) {
        Optional<Person> person = selectPeron(id);
        if (person.isEmpty())
            return 0;
        persons.remove(person.get());
        return 1;
    }

    @Override
    public int updatePerson(UUID id, Person person) {
        return selectPeron(id).map(personne -> {
            int indexPersonToUpdate = persons.indexOf(personne);
            if (indexPersonToUpdate >= 0) {
                persons.set(indexPersonToUpdate, new Person(id, person.getName()));
                return 1;
            }
            return 0;
        }).orElse(0);
    }

    @Override
    public Optional<Person> selectPeron(UUID id) {
        return persons.stream().filter(person -> person.getUUid().equals(id)).findFirst();
    }
}
