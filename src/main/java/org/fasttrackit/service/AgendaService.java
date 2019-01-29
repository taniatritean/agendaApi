package org.fasttrackit.service;

import org.fasttrackit.dto.AgendaDTO;
import org.fasttrackit.dto.ContactDTO;
import org.fasttrackit.model.Agenda;
import org.fasttrackit.model.Contact;
import org.fasttrackit.repo.AgendaRepository;
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
public class AgendaService {

    @Autowired
    private AgendaRepository agendaRepository;

    @Transactional
    public List<AgendaDTO> getAllAgendas() {
        List<AgendaDTO> result = new ArrayList<>();
        Iterator<Agenda> iterator = agendaRepository.findAll().iterator();
        while (iterator.hasNext()) {
            Agenda next = iterator.next();
            result.add(ConvertorUtils.convertToDto(next));
        }
        return result;
    }

    @Transactional
    public AgendaDTO getAgenda(long id) {
        Agenda one = agendaRepository.findOne(id);
        if (one == null) {
            throw new IllegalArgumentException("Invalid id");
        }
        AgendaDTO dto = ConvertorUtils.convertToDto(one);
        return dto;
    }


}
