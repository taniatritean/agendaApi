package org.fasttrackit.service;

import org.fasttrackit.dto.AgendaDTO;
import org.fasttrackit.dto.ContactDTO;
import org.fasttrackit.model.Agenda;
import org.fasttrackit.model.Contact;
import org.fasttrackit.repo.AgendaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ttritean
 * @since 1/15/2019
 */

@Service
public class AgendaService {

    @Autowired
    private AgendaRepository agendaRepository;

    public AgendaDTO getAgenda(long id) {

        Agenda one = agendaRepository.findOne(id);
        AgendaDTO dto = convertToDto(one);
        return dto;
    }

    private AgendaDTO convertToDto(Agenda one) {
        AgendaDTO dto = new AgendaDTO();
        dto.setId(one.getId());
        dto.setName(one.getName());
        List<ContactDTO> contacteDto = new ArrayList<>();
        for (Contact c : one.getContacte()) {
            ContactDTO cd = convertToDto(c);
            contacteDto.add(cd);
        }

        dto.setContacte(contacteDto);
        return dto;
    }

    private ContactDTO convertToDto(Contact c) {
        ContactDTO cd = new ContactDTO();
        cd.setFirstName(c.getFirstName());
        cd.setLastName(c.getLastName());
        cd.setPhone(c.getPhone());
        cd.setId(c.getId());
        return cd;
    }
}
