package com.evertonluissp.bravichallenge.entities;

import com.evertonluissp.bravichallenge.enums.ContactType;

import static java.util.Objects.hash;

public class Contact {

    public int id;
    public String value;
    public ContactType type;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        var contact = (Contact) o;
        return id == contact.id;
    }

    @Override
    public int hashCode() {
        return hash(id);
    }

}
