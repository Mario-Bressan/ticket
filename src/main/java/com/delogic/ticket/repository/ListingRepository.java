package com.delogic.ticket.repository;

import com.delogic.ticket.entity.Listing;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ListingRepository extends CrudRepository<Listing, Long> {
}
