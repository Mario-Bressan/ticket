package com.delogic.ticket.service;

import com.delogic.ticket.converter.EventConverter;
import com.delogic.ticket.dto.EventDto;
import com.delogic.ticket.repository.EventFilterRepository;
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
public class EventFilterService {

    private final EventFilterRepository eventRepository;
    private final EventConverter eventConverter;


    public Page<EventDto> findByDate(LocalDate date, Long categoryId, String city) {
        Pageable pageable = PageRequest.of(0, 10, Sort.by(Sort.Direction.DESC, "date.calendarDate"));
        return eventRepository.findAll(new EventSpecification(date, categoryId, city), pageable).map(eventConverter::toDto);
    }
}
