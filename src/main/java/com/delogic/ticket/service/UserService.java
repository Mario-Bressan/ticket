package com.delogic.ticket.service;

import com.delogic.ticket.converter.UserConverter;
import com.delogic.ticket.dto.UserDto;
import com.delogic.ticket.entity.User;
import com.delogic.ticket.exception.NotFoundException;
import com.delogic.ticket.repository.UsersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UsersRepository usersRepository;
    private final UserConverter userConverter;

    public Page<Long> findAll(Pageable pageable) {
        return usersRepository.findAll(pageable)
                .map(User::getId);
    }

    public UserDto findById(Long id) {
        return usersRepository.findById(id).map(userConverter::toDto).orElseThrow(NotFoundException::new);
    }
}
