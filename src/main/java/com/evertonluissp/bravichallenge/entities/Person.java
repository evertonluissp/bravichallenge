package com.evertonluissp.bravichallenge.entities;

import java.util.List;

import static java.util.Objects.hash;

public class Person {

    public int id;
    public String name;
    public List<Contact> contacts;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        var person = (Person) o;
        return id == person.id;
    }

    @Override
    public int hashCode() {
        return hash(id);
    }

}
