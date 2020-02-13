package com.evertonluissp.bravichallenge.dtos;

import com.evertonluissp.bravichallenge.entities.Person;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import java.util.List;
import java.util.stream.Collectors;

public class PersonDTO {

    @NotBlank
    public String name;
    @Valid
    public List<ContactDTO> contacts;

    public Person toEntity() {
        var thiz = this;
        return new Person() {{
            name = thiz.name;
            contacts = thiz.contacts.stream().map(ContactDTO::toContact).collect(Collectors.toList());
        }};
    }

}
