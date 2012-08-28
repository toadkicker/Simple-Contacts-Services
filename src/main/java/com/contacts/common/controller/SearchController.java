package com.contacts.common.controller;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.WebRequest;
import java.util.List;

/**
 * Date: 8/26/12
 * Time: 3:13 PM
 */
@Controller
@RequestMapping("/contacts/search")
@Transactional
public class SearchController {

    @Autowired
    private SessionFactory sessionFactory;

    @RequestMapping(method = RequestMethod.GET)
    public @ResponseBody List getSearch(WebRequest webRequest) {
        String firstName = webRequest.getParameter("firstName");
        String lastName = webRequest.getParameter("lastName");
        String areaCode = webRequest.getParameter("areaCode");
        Query query = sessionFactory.getCurrentSession()
                .createQuery("Select c From Contact c where c.firstName like :firstName and c.lastName like :lastName and c.areaCode like :areaCode");
        query.setParameter("firstName", (firstName == null ? "%" : firstName + "%"))
                .setParameter("lastName", (lastName == null ? "%" : lastName + "%"))
                .setParameter("areaCode", (areaCode == null ? "%" : areaCode + "%"));
        return query.list();
    }

}
