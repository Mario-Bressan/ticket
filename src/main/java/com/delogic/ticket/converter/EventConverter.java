package com.delogic.ticket.converter;

import com.delogic.ticket.dto.EventDto;
import com.delogic.ticket.entity.Event;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface EventConverter {

    @Mapping(target = "date", source = "event.date.calendarDate")
    @Mapping(target = "categoryId", source = "event.category.id")
    @Mapping(target = "categoryName", source = "event.category.name")
    @Mapping(target = "city", source = "event.venue.city")
    EventDto toDto(Event event);
}
