package com.evertonluissp.bravichallenge.controllers.v1;

import com.evertonluissp.bravichallenge.dtos.PersonDTO;
import com.evertonluissp.bravichallenge.entities.Person;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.evertonluissp.bravichallenge.controllers.v1.PersonsController.PATH;

@RestController
@RequestMapping(PATH)
public class PersonsController {

    public static final String PATH = "/v1/persons";

    @PostMapping
    public ResponseEntity<Person> save(PersonDTO person) {
        throw new RuntimeException();
    }

    @GetMapping
    public ResponseEntity<List<Person>> persons() {
        throw new RuntimeException();
    }

    @GetMapping("{id}")
    public ResponseEntity<Person> person() {
        throw new RuntimeException();
    }

    @PutMapping("{id}")
    public ResponseEntity<Person> update(PersonDTO person) {
        throw new RuntimeException();
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Person> delete() {
        throw new RuntimeException();
    }

}
