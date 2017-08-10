package com.spartan.code.exemplo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spartan.code.exemplo.domain.Contact;
import com.spartan.code.exemplo.domain.ContactType;

@Repository
public interface ContactRepository extends JpaRepository<Contact, Long> {

    List<Contact> findByType(ContactType type);

}
