package com.delogic.ticket.repository;

import com.delogic.ticket.entity.EventDate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DateRepository extends JpaRepository<EventDate, Integer> {
}
