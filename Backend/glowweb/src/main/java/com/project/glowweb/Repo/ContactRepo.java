package com.project.glowweb.Repo;


import com.project.glowweb.Entity.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactRepo extends JpaRepository<Contact, Integer> {
}
