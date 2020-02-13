package com.evertonluissp.bravichallenge.controllers.v1;

import com.evertonluissp.bravichallenge.dtos.PersonDTO;
import com.evertonluissp.bravichallenge.entities.Person;
import com.evertonluissp.bravichallenge.repositories.PersonsRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.Collection;
import java.util.Optional;

import static com.evertonluissp.bravichallenge.controllers.v1.PersonsController.PATH;
import static org.springframework.http.ResponseEntity.*;

@RestController
@RequestMapping(PATH)
public class PersonsController {

    public static final String PATH = "/v1/persons";

    public final PersonsRepository repository;

    public PersonsController(PersonsRepository repository) {
        this.repository = repository;
    }

    @PostMapping
    public ResponseEntity<?> save(@RequestBody PersonDTO person) {
        var personId = repository.save(person.toEntity());
        return created(URI.create(PATH + "/" + personId)).build();
    }

    @GetMapping
    public ResponseEntity<Collection<Person>> persons() {
        var persons = repository.persons();
        return persons.isEmpty() ? notFound().build() : ok(persons);
    }

    @GetMapping("{id}")
    public ResponseEntity<Person> person(@PathVariable int id) {
        return repository.person(id).map(ResponseEntity::ok).orElseGet(() -> notFound().build());
    }

    @PutMapping("{id}")
    public ResponseEntity<?> update(@PathVariable int id, @RequestBody PersonDTO person) {
        repository.update(id, person.toEntity());
        return ok().build();
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Person> delete(@PathVariable int id) {
        repository.delete(id);
        return ok().build();
    }

}
