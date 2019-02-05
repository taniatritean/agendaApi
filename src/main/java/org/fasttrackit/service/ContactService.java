package org.fasttrackit.service;

import org.fasttrackit.dto.AgendaDTO;
import org.fasttrackit.dto.ContactDTO;
import org.fasttrackit.model.Agenda;
import org.fasttrackit.model.Contact;
import org.fasttrackit.repo.AgendaRepository;
import org.fasttrackit.repo.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author ttritean
 * @since 1/15/2019
 */

@Service
public class ContactService {

    @Autowired
    private AgendaRepository agendaRepository;
    @Autowired
    private ContactRepository contactRepository;

    @Transactional
    public void update(ContactDTO contact) {
        Contact one = contactRepository.findOne(contact.getId());
        if (one == null) {
            throw new IllegalArgumentException("Invalid id");

        }
        one.setPhone(contact.getPhone());
        one.setLastName(contact.getLastName());
        one.setFirstName(contact.getFirstName());
        contactRepository.save(one);

    }

    @Transactional
    public void create(ContactDTO contact, long agendaId) {

        Contact one = new Contact();
        one.setPhone(contact.getPhone());
        one.setLastName(contact.getLastName());
        one.setFirstName(contact.getFirstName());

        Agenda agenda = agendaRepository.findOne(agendaId);
        agenda.getContacte().add(one);
        agendaRepository.save(agenda);
    }

    public void delete(long contactId) {
        contactRepository.delete(contactId);
    }
}
