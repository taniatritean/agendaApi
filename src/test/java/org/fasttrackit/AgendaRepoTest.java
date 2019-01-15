package org.fasttrackit;

import org.fasttrackit.model.Agenda;
import org.fasttrackit.model.Contact;
import org.fasttrackit.model.Sectie;
import org.fasttrackit.repo.AgendaRepository;
import org.fasttrackit.repo.SectieRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
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

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = FacultateApplication.class,
        loader = SpringApplicationContextLoader.class,
        initializers = ConfigFileApplicationContextInitializer.class)

public class AgendaRepoTest {

    @Autowired
    private AgendaRepository repository;

    @Test
    public void testSave() {

        Agenda agenda = new Agenda();
        agenda.setName("My agenda");
        List<Contact> contacte = new ArrayList<>();
        Contact c = new Contact();
        c.setFirstName("firtsname");
        c.setLastName("ln");
        c.setPhone("00000000000");
        contacte.add(c);
        agenda.setContacte(contacte);
        repository.save(agenda);

    }

}
