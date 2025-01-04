package com.delogic.ticket.converter;

import com.delogic.ticket.dto.UserDto;
import com.delogic.ticket.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserConverter {

    UserDto toDto(User user);
}
