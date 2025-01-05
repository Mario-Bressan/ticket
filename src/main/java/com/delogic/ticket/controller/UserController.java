package com.delogic.ticket.controller;

import com.delogic.ticket.dto.UserDto;
import com.delogic.ticket.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;


    @GetMapping
    public ResponseEntity<Page<Long>> findAll(@RequestParam int page, @RequestParam int size) {
        return ResponseEntity.ok(userService.findAll(Pageable.ofSize(size).withPage(page)));
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDto> findById(@PathVariable Long id) {
        return ResponseEntity.ok(userService.findById(id));
    }
}
