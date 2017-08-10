package com.spartan.code.exemplo.service;

import static org.springframework.data.domain.ExampleMatcher.GenericPropertyMatchers.exact;
import static org.springframework.data.domain.ExampleMatcher.matching;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.spartan.code.exemplo.domain.Contact;
import com.spartan.code.exemplo.domain.ContactType;
import com.spartan.code.exemplo.dto.FilterContactDTO;
import com.spartan.code.exemplo.repository.ContactRepository;

import lombok.extern.java.Log;

@Log
@Service
public class ContactService {

    private final ContactRepository repository;

    @Autowired
    public ContactService(ContactRepository repository) {
        this.repository = repository;
    }


    public List<Contact> findAll() {
        log.info("Find All");
        return repository.findAll();
    }

    public Contact findOne(Long id) {
        log.info("Find One");
        return repository.findOne(id);
    }

    public Contact add(Contact contact) {
        log.info(String.format("Add: %s ", contact.toString()));
        return repository.save(contact);
    }

    public Contact update(Long id, Contact contact) {
        log.info(String.format("Update: %s ", contact.toString()));
        Contact entity = repository.findOne(id);
        entity.setEmail(contact.getEmail());

        return repository.save(entity);
    }

    public void delete(Long id) {
        log.info(String.format("Delete: %d", id));
        repository.delete(id);
    }

    public Page<Contact> findByFilter(FilterContactDTO filter, Pageable pageable) {
        Contact contact = Contact.builder().type(filter.getType()).build();

        return repository.findAll(
            Example.of(contact, matching().withMatcher("type", exact())),
            pageable
        );
    }
}
