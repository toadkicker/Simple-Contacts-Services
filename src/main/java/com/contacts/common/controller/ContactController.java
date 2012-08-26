package com.contacts.common.controller;

import com.contacts.common.model.Contact;
import com.contacts.common.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.ArrayList;
import java.util.List;

/**
 * Date: 8/25/12
 * Time: 3:30 PM
 */
@Controller
@RequestMapping("/contact")
public class ContactController {

    @Autowired
    private ContactService contactService;

	@RequestMapping(value="{name}", method = RequestMethod.GET)
	public @ResponseBody List<Contact> getContactInJSON(@PathVariable String name) {
        return testRoutine();
	}

    @RequestMapping(value = "test", method = RequestMethod.GET)
    public String getContactInJSONPOST(ModelMap modelMap) {
        if (contactService.getAllContacts().size() > 0) {
            modelMap.addAttribute("message", "Test data has already been loaded");
            return "test-data-fail";
        } else {
            testRoutinePersist();
            modelMap.addAttribute("message", "Added test data successfully");
            return "test-data-success";
        }
    }

    @RequestMapping(value="all", method = RequestMethod.GET)
    public @ResponseBody List<Contact> getAllContacts() {
        return contactService.getAllContacts();
    }

    @RequestMapping(value="f/{firstName}", method = RequestMethod.GET)
    public @ResponseBody List<Contact> getContactsByFirstName(@PathVariable String firstName) {
        return contactService.getContactsByFirstName(firstName);
    }

    @RequestMapping(value="l/{lastName}", method = RequestMethod.GET)
    public @ResponseBody List<Contact> getContactsByLastName(@PathVariable String lastName) {
        return contactService.getContactsByLastName(lastName);
    }

    @RequestMapping(value="ac/{areaCode}", method = RequestMethod.GET)
    public @ResponseBody List<Contact> getContactsByAreaCode(@PathVariable String areaCode) {
        return contactService.getContactsByAreaCode(areaCode);
    }

    private void testRoutinePersist() {
        Contact c = new Contact();
        Contact d = new Contact();
        c.setFirstName("Alpha");
        d.setFirstName("Bravo");
        c.setLastName("Zephyr");
        d.setLastName("Zephyr");
        c.setAreaCode("619");
        d.setAreaCode("415");
        contactService.addNewContact(c);
        contactService.addNewContact(d);
    }

    private List<Contact> testRoutine() {
        Contact c = new Contact();
        Contact d = new Contact();
        c.setFirstName("Charlie");
        d.setFirstName("Delta");
        c.setLastName("Zephyr");
        d.setLastName("Whiskey");
        c.setAreaCode("209");
        d.setAreaCode("858");
        List<Contact> result = new ArrayList<Contact>();
        result.add(c);
        result.add(d);
        return result;
    }
}