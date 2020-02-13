package com.evertonluissp.bravichallenge.controllers.v1;

import com.evertonluissp.bravichallenge.dtos.PersonDTO;
import com.evertonluissp.bravichallenge.entities.Person;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

import static com.evertonluissp.bravichallenge.controllers.v1.PersonsController.PATH;

@RestController
@RequestMapping(PATH)
public class PersonsController {

    public static final String PATH = "/v1/persons";

    @PostMapping
    public ResponseEntity<?> save(@RequestBody PersonDTO person) {
        throw new RuntimeException();
    }

    @GetMapping
    public ResponseEntity<Collection<Person>> persons() {
        throw new RuntimeException();
    }

    @GetMapping("{id}")
    public ResponseEntity<Person> person(@PathVariable int id) {
        throw new RuntimeException();
    }

    @PutMapping("{id}")
    public ResponseEntity<?> update(@PathVariable int id, @RequestBody PersonDTO person) {
        throw new RuntimeException();
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Person> delete(@PathVariable int id) {
        throw new RuntimeException();
    }

}
