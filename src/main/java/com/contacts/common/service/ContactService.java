package com.contacts.common.service;

import com.contacts.common.model.Contact;
import com.contacts.common.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * Date: 8/25/12
 * Time: 12:55 PM
 */
@Service
public class ContactService {

    @Autowired
    private ContactRepository contactRepository;

    public List<Contact> getAllContacts() {
        return contactRepository.getContacts();
    }

    public void addNewContact(Contact contact) {
        contactRepository.addNewContact(contact);
    }

    public List<Contact> getContactsByFirstName(String firstName) {
        return contactRepository.getContactsByFirstName(firstName);
    }

    public List<Contact> getContactsByLastName(String lastName) {
        return contactRepository.getContactsByLastName(lastName);
    }

    public List<Contact> getContactsByAreaCode(String areaCode) {
        return contactRepository.getContactsByAreaCode(areaCode);
    }

    public Contact getContact(Long id) {
        return contactRepository.getContact(id);
    }

    public void updateContact(Contact contact) {
        contactRepository.updateContact(contact);
    }

    public void removeContact(Contact contact) {
        contactRepository.removeContact(contact);
    }
}
