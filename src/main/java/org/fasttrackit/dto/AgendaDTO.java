package org.fasttrackit.dto;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ttritean
 * @since 1/15/2019
 */
public class AgendaDTO {
    private Long id;
    
    private String name;

    private List<ContactDTO> contacte = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<ContactDTO> getContacte() {
        return contacte;
    }

    public void setContacte(List<ContactDTO> contacte) {
        this.contacte = contacte;
    }
}
