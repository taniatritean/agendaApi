package org.fasttrackit.repo;

import org.fasttrackit.model.Agenda;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * @author ttritean
 * @since 1/15/2019
 */
public interface AgendaRepository extends
        PagingAndSortingRepository<Agenda, Long> {
}
