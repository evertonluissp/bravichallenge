package com.evertonluissp.bravichallenge.repositories;

import com.evertonluissp.bravichallenge.entities.Contact;
import com.evertonluissp.bravichallenge.exceptions.NotFoundException;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Repository
public class ContactsRepository {

    private static int availableId = 0;

    protected Set<Contact> contacts = new HashSet<>();

    public int save(Contact contact) {
        contact.id = availableId++;
        contacts.add(contact);
        return contact.id;
    }

    public Collection<Contact> contacts() {
        return contacts;
    }

    public Optional<Contact> contact(int id) {
        return contacts.stream().filter(contact -> contact.id == id).findAny();
    }

    public void update(int id, Contact contact) {
        contact(id)
                .ifPresentOrElse(
                        storedContact -> {
                            storedContact.value = contact.value;
                            storedContact.type = contact.type;
                        },
                        () -> {
                            throw new NotFoundException();
                        }
                );
    }

    public void delete(int id) {
        contacts.remove(contact(id).orElseThrow(NotFoundException::new));
    }

}
