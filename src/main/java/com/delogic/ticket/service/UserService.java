package com.delogic.ticket.service;

import com.delogic.ticket.converter.UserConverter;
import com.delogic.ticket.dto.UserDto;
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

    public Page<UserDto> findAll(Pageable pageable) {
        return usersRepository.findAll(pageable)
                .map(userConverter::toDto);
    }
}
