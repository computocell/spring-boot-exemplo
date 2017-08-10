package com.spartan.code.exemplo;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import com.spartan.code.exemplo.domain.Contact;
import com.spartan.code.exemplo.domain.ContactType;
import com.spartan.code.exemplo.service.ContactService;

@SpringBootTest
@RunWith(SpringRunner.class)
@TestPropertySource(locations = "classpath:test.properties")
public class ExemploApplicationTests {

    @Autowired
    private ContactService service;

    private Long createContactId;

    @Before
    public void createContactIfNotExists() {
        Contact contact = service.add(
            Contact.builder()
                .email("contact@mail.com")
                .name("Contact Test")
                .phone("+55 31 91919191")
                .type(ContactType.WORK)
                .build()
        );
        createContactId = contact.getId();
    }

    @After
    public void deleteContactIfNotExists() {
        service.delete(createContactId);
    }

    @Test
    public void findAllTest() {
        List<Contact> contacts = service.findAll();
        assertThat(contacts).isNotEmpty();
    }

    @Test
    public void findOneTest() {
        Contact contact = service.findOne(createContactId);
        assertThat(contact.getName()).contains("Contact");
        assertThat(contact.getEmail()).startsWith("contact");
        assertThat(contact.getPhone()).endsWith("9191");
        assertThat(contact.getType()).isEqualTo(ContactType.WORK);
    }

}
