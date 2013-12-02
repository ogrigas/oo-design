package oo.coupling;

import static oo.coupling.Contact.Type;

import java.util.HashSet;
import java.util.Set;

public class Customer {

    private long id;
    private String name;
    private Set<Contact> contacts;

    public Customer(long id, String name, String email) {
        this.id = id;
        this.name = name;
        this.contacts = new HashSet<Contact>();
        this.contacts.add(new Contact(Type.EMAIL, email));
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Contact> getContacts() {
        return contacts;
    }
}
