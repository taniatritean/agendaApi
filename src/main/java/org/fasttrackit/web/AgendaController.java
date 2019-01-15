package org.fasttrackit.web;

import org.fasttrackit.dto.AgendaDTO;
import org.fasttrackit.service.AgendaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author ttritean
 * @since 1/8/2019
 */
@RestController
public class AgendaController {


    @Autowired
    private AgendaService service;

    @RequestMapping(path = "/agenda", method = RequestMethod.POST)
    public void saveSectie(@RequestBody AgendaDTO agenda) {

        //service.save(sectie);


    }

    @RequestMapping(path = "/agenda/{id}", method = RequestMethod.GET)
    @ResponseBody
    public AgendaDTO getAgendaById(@PathVariable long id) {
        return service.getAgenda(id);
    }


}


