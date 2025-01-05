package com.delogic.ticket.repository;

import com.delogic.ticket.entity.Venue;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VenueRepository extends CrudRepository<Venue, Long> {
}
