package com.delogic.ticket.service;

import com.delogic.ticket.entity.Event;
import com.delogic.ticket.repository.EventRepository;
import com.delogic.ticket.specification.EventSpecification;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDate;


@Service
@RequiredArgsConstructor
public class EventService {

    private final EventRepository eventRepository;


    public Page<Long> findAll(Pageable pageable) {
        return eventRepository.findAll(pageable)
                .map(Event::getId);
    }


}
