package com.delogic.ticket.controller;

import com.delogic.ticket.entity.Event;
import com.delogic.ticket.service.EventService;
import lombok.RequiredArgsConstructor;
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


//    @GetMapping
//    public ResponseEntity<Event> findBy(@RequestParam LocalDate date, @RequestParam(required = false, value = "category-id") Integer categoryId, @RequestParam(required = false) String city) {
//        return ResponseEntity.ok()
//    }
}
