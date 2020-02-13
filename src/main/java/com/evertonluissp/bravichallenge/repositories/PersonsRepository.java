package com.evertonluissp.bravichallenge.repositories;

import com.evertonluissp.bravichallenge.entities.Person;
import com.evertonluissp.bravichallenge.exceptions.NotFoundException;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Repository
public class PersonsRepository {

    private static int availableId = 0;

    private Set<Person> persons = new HashSet<>();

    public int save(Person person) {
        person.id = availableId++;
        persons.add(person);
        return person.id;
    }

    public Collection<Person> persons() {
        return persons;
    }

    public Optional<Person> person(int id) {
        return persons.stream().filter(person -> person.id == id).findFirst();
    }

    public void update(int id, Person person) {
        person(id)
                .ifPresentOrElse(
                        storedPerson -> {
                            storedPerson.name = person.name;
                            storedPerson.contacts = person.contacts;
                        },
                        () -> {
                            throw new NotFoundException();
                        }
                );
    }

    public void delete(int id) {
        var person = person(id).orElseThrow(NotFoundException::new);
        persons.remove(person);
    }

}
