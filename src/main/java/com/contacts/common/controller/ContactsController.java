package com.contacts.common.controller;

import com.contacts.common.model.Contact;
import com.contacts.common.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/**
 * Date: 8/25/12
 * Time: 3:30 PM
 */
@Controller
@RequestMapping("/contacts")
public class ContactsController {

    @Autowired
    private ContactService contactService;

    @RequestMapping(method = RequestMethod.GET)
    public @ResponseBody List<Contact> getAllContacts() {
        return contactService.getAllContacts();
    }

    @RequestMapping(value = "id/{id}", method = RequestMethod.GET)
    public @ResponseBody Contact getContact(@PathVariable String id) {
        return contactService.getContact(Long.valueOf(id));
    }

    @RequestMapping(value = "create", method = RequestMethod.GET)
    public String getNewContactForm(ModelMap modelMap) {
        modelMap.addAttribute("message", "complete form to add a new contact");
        modelMap.addAttribute("buttonMessage", "Add Contact");
        modelMap.addAttribute("actionName", "create");
        modelMap.addAttribute("actionMethod", "post");
        modelMap.addAttribute("contact", new Contact());
        return "contact-form";
    }

    @RequestMapping(value = "create", method = RequestMethod.POST)
    public String getSubmitNew(@ModelAttribute("contact") Contact contact, BindingResult result, ModelMap modelMap) {
        modelMap.addAttribute("contact", contact);
        contactService.addNewContact(contact);
        return "redirect:/contacts";
    }

    @RequestMapping(value = "edit/{id}", method = RequestMethod.GET)
    public String getUpdateContactForm(@PathVariable String id, ModelMap modelMap) {
        Contact updatedContact = contactService.getContact(Long.valueOf(id));
        modelMap.addAttribute("message", "submit changes in order to update contact");
        modelMap.addAttribute("contact", updatedContact);
        modelMap.addAttribute("buttonMessage", "Update Contact");
        modelMap.addAttribute("actionName", "../edit");
        modelMap.addAttribute("actionMethod", "put");
        return "contact-form";
    }

    @RequestMapping(value = "edit", method = RequestMethod.PUT)
    public String getSubmitUpdate(@ModelAttribute("contact") Contact contact, BindingResult result, ModelMap modelMap) {
        contactService.updateContact(contact);
        return "redirect:/contacts";
    }

    @RequestMapping(value = "delete/{id}", method = RequestMethod.GET)
    public String getDeleteContactForm(@PathVariable String id, ModelMap modelMap) {
        Contact removedContact = contactService.getContact(Long.valueOf(id));
        modelMap.addAttribute("message", "confirm removal. is this the correct contact to remove?");
        modelMap.addAttribute("contact", removedContact);
        modelMap.addAttribute("buttonMessage", "Remove Contact");
        modelMap.addAttribute("actionName", "../delete");
        modelMap.addAttribute("actionMethod", "delete");
        return "contact-form";
    }

    @RequestMapping(value = "delete", method = RequestMethod.DELETE)
    public String getSubmitDelete(@ModelAttribute("contact") Contact contact, BindingResult result, ModelMap modelMap) {
        contactService.removeContact(contact);
        return "redirect:/contacts";
    }
}