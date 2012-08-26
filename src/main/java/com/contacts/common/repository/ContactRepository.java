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

    public List getContacts() {
        return sessionFactory.getCurrentSession().createQuery("Select c From Contact c").list();
    }

    public void addNewContact(Contact contact) {
        if (contact != null && contact.getId() == null) {
            sessionFactory.getCurrentSession().save(contact);
            sessionFactory.getCurrentSession().flush();
        }
    }

    public List getContactsByFirstName(String firstName) {
        return sessionFactory.getCurrentSession().createQuery("Select c From Contact c where c.firstName like :firstName").setParameter("firstName", firstName + "%").list();
    }

    public List getContactsByLastName(String lastName) {
        return sessionFactory.getCurrentSession().createQuery("Select c From Contact c where c.lastName like :lastName").setParameter("lastName", lastName + "%").list();
    }

    public List getContactsByAreaCode(String areaCode) {
        return sessionFactory.getCurrentSession().createQuery("Select c From Contact c where c.areaCode = :areaCode").setParameter("areaCode", areaCode).list();
    }

    public Contact getContact(Long id) {
        return (Contact) sessionFactory.getCurrentSession().get(Contact.class, id);
    }

    public void updateContact(Contact contact) {
        sessionFactory.getCurrentSession().update(contact);
    }

    public void removeContact(Contact contact) {
        sessionFactory.getCurrentSession().delete(contact);
    }
}
