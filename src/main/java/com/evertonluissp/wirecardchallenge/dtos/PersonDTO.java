package com.evertonluissp.wirecardchallenge.dtos;

import com.evertonluissp.wirecardchallenge.entities.Person;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.util.List;
import java.util.stream.Collectors;

public class PersonDTO {

    @NotBlank
    public String name;
    @NotEmpty
    @Valid
    public List<ContactDTO> contacts;

    public Person toPerson() {
        var thiz = this;
        return new Person() {{
            name = thiz.name;
            contacts = thiz.contacts.stream().map(ContactDTO::toContact).collect(Collectors.toList());
        }};
    }

}
