package com.delogic.ticket.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EventDto {

    private Long id;
    private LocalDate date;
    private Long categoryId;
    private String categoryName;
    private String city;
}
