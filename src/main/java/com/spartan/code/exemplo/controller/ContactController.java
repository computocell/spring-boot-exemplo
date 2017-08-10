package com.spartan.code.exemplo.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spartan.code.exemplo.domain.Contact;
import com.spartan.code.exemplo.dto.FilterContactDTO;
import com.spartan.code.exemplo.service.ContactService;

@RestController
@RequestMapping("/api/contact")
public class ContactController {

    private final ContactService service;

    @Autowired
    public ContactController(ContactService service) {
        this.service = service;
    }

    @GetMapping
    public List<Contact> findAll() {
        return service.findAll();
    }

    @GetMapping(value = "/filter")
    public Page<Contact> findByFilter(@Valid FilterContactDTO filter, Pageable pageable) {
        return service.findByFilter(filter, pageable);
    }

    @GetMapping(value = "/{id}")
    public Contact findOne(@PathVariable Long id) {
        return service.findOne(id);
    }

    @PostMapping
    public Contact add(@RequestBody Contact contact) {
        return service.add(contact);
    }

    @PutMapping(value = "/{id}")
    public Contact update(@PathVariable Long id, @RequestBody Contact contact) {
        return service.update(id, contact);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
