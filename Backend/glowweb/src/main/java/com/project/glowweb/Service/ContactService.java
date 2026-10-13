package com.project.glowweb.Service;


import com.project.glowweb.Entity.Contact;
import com.project.glowweb.Repo.ContactRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContactService {

    @Autowired
    private ContactRepo contactRepo;

    public Contact saveContact(Contact contact) {
        return contactRepo.save(contact);
    }
}