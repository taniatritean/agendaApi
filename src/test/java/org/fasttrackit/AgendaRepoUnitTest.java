package org.fasttrackit;

import org.fasttrackit.dto.AgendaDTO;
import org.fasttrackit.model.Agenda;
import org.fasttrackit.model.Contact;
import org.fasttrackit.repo.AgendaRepository;
import org.fasttrackit.service.AgendaService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.ConfigFileApplicationContextInitializer;
import org.springframework.boot.test.SpringApplicationContextLoader;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ttritean
 * @since 1/8/2019
 */

@RunWith(MockitoJUnitRunner.class)
public class AgendaRepoUnitTest {

    @Mock
    private AgendaRepository repository;

    @InjectMocks
    private AgendaService service;

    @Test
    public void testSave() {

        Agenda agenda = getAgenda("agenda0", "firtsname", "ln", "0000");
        Agenda savedAgenda = service.save(agenda);

        Assert.assertEquals(agenda.getName() + "1", savedAgenda.getName());
        Assert.assertEquals(agenda.getContacte().size(), savedAgenda.getContacte().size());

    }

    @Test
    public void testGetById() {
        Agenda agendaToBeReturned = new Agenda();
        agendaToBeReturned.setId(1L);
        agendaToBeReturned.setName("agenda0");

        Mockito.doReturn(agendaToBeReturned)
                .when(repository).findOne(1L);
        
        AgendaDTO agenda = service.getAgenda(1L);

        Assert.assertNotNull(agenda);
        Assert.assertEquals("agenda0", agenda.getName());
        Assert.assertEquals(new Long(1), agenda.getId());
    }


    private Agenda getAgenda(String agendaName, String firtsname, String ln, String phone) {
        Agenda agenda = new Agenda();
        agenda.setName(agendaName);
        List<Contact> contacte = new ArrayList<>();
        Contact c = new Contact();
        c.setFirstName(firtsname);
        c.setLastName(ln);
        c.setPhone(phone);
        contacte.add(c);
        agenda.setContacte(contacte);
        return agenda;
    }

}
