package com.delogic.ticket.controller;

import com.delogic.ticket.entity.EventDate;
import com.delogic.ticket.repository.DateRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/dates")
public class DateController {

    private final DateRepository dateRepository;

    @GetMapping
    public ResponseEntity<List<EventDate>> findAll() {
        return new ResponseEntity<>(dateRepository.findAll(), HttpStatus.OK);
    }
}
