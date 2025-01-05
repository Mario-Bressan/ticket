package com.delogic.ticket.repository;

import com.delogic.ticket.entity.Event;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventRepository extends PagingAndSortingRepository<Event, Long>, CrudRepository<Event, Long> {

    Page<Event> findAll(Pageable pageable);

}
