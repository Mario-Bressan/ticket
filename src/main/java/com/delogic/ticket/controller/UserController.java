package com.delogic.ticket.controller;

import com.delogic.ticket.dto.UserDto;
import com.delogic.ticket.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;


    @GetMapping
    public ResponseEntity<Page<UserDto>> findAll(@RequestParam int page, @RequestParam int size) {
        return ResponseEntity.ok(userService.findAll(Pageable.ofSize(size).withPage(page)));
    }
}
