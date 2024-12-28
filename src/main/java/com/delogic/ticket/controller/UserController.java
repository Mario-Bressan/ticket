package com.delogic.ticket.controller;

import com.delogic.ticket.entity.User;
import com.delogic.ticket.repository.UsersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.StreamSupport;

@RestController
@RequestMapping("/v1/users")
@RequiredArgsConstructor
public class UserController {

    private final UsersRepository usersRepository;


    @GetMapping
    public ResponseEntity<List<User>> findAll() {
        return ResponseEntity.ok(StreamSupport.stream(usersRepository.findAll().spliterator(), false)
                .toList());
    }
}
