package com.contacts.common.repository;

import com.contacts.common.model.Contact;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

/**
 * Date: 8/25/12
 * Time: 12:51 PM
 */
@Repository
@Transactional
public class ContactRepository {

    @Autowired
    private SessionFactory sessionFactory;

    public List<Contact> getContacts() {
        return sessionFactory.getCurrentSession().createQuery("Select c From Contact c").list();
    }

    public void addNewContact(Contact contact) {
        if (contact != null && contact.getId() == null) {
            sessionFactory.getCurrentSession().save(contact);
            sessionFactory.getCurrentSession().flush();
        }
    }

    public List<Contact> getContactsByFirstName(String firstName) {
        return sessionFactory.getCurrentSession().createQuery("Select c From Contact c where c.firstName like :firstName").setParameter("firstName", firstName + "%").list();
    }

    public List<Contact> getContactsByLastName(String lastName) {
        return sessionFactory.getCurrentSession().createQuery("Select c From Contact c where c.lastName like :lastName").setParameter("lastName", lastName + "%").list();
    }

    public List<Contact> getContactsByAreaCode(String areaCode) {
        return sessionFactory.getCurrentSession().createQuery("Select c From Contact c where c.areaCode = :areaCode").setParameter("areaCode", areaCode).list();
    }
}
