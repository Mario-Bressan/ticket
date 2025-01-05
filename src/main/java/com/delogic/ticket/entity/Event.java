package com.delogic.ticket.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "events")
public class Event {

    @Id
    @Column(name = "event_id")
    private Long id;
    @Column(name = "event_name")
    private String name;
    @Column(name = "event_start_time")
    private LocalDateTime startTime;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "date_id", referencedColumnName = "date_id")
    private Date date;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id", referencedColumnName = "category_id")
    private Category category;
}
