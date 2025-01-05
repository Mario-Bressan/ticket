package com.delogic.ticket.controller;

import com.delogic.ticket.dto.EventDto;
import com.delogic.ticket.service.EventFilterService;
import com.delogic.ticket.service.EventService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
@RequestMapping("/v1/events")
@RequiredArgsConstructor
public class EventController {

    private final EventService eventService;
    private final EventFilterService eventFilterService;


    @GetMapping
    public ResponseEntity<Page<Long>> findAll(@RequestParam int page, @RequestParam int size) {
        return ResponseEntity.ok(eventService.findAll(Pageable.ofSize(size).withPage(page)));
    }

    @GetMapping("/filter")
    public ResponseEntity<Page<EventDto>> findBy(@RequestParam LocalDate date, @RequestParam(required = false, value = "category-id") Long categoryId, @RequestParam(required = false) String city) {
        return ResponseEntity.ok(eventFilterService.findByDate(date, categoryId, city));
    }
}
