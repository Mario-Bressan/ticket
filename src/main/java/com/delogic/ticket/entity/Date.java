package com.delogic.ticket.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "dates")
public class Date {

    @Id
    @Column(name = "date_id")
    private Long id;
    private String calendarDate;
    private String day;
    private Integer week;
    private String month;
    private Integer quarter;
    private Integer year;
    private Boolean holidayFlag;
}
