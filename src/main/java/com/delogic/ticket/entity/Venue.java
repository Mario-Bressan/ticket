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
@Table(name = "venues")
public class Venue {

    @Id
    @Column(name = "venue_id")
    private Long id;
    @Column(name = "venue_name")
    private String name;
    private String city;
    private String state;
    private Integer seatingCapacity;
}
