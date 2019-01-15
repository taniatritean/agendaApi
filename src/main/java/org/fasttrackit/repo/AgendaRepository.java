package org.fasttrackit.repo;

import org.fasttrackit.model.Agenda;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

/**
 * @author ttritean
 * @since 1/15/2019
 */
public interface AgendaRepository extends
        PagingAndSortingRepository<Agenda, Long> {


    public List<Agenda> findAgendaByName(String name);

    @Query("select a from Agenda a where name like ?1%")
    public List<Agenda> findAgendaWhereNameLike(String namePart);

}
