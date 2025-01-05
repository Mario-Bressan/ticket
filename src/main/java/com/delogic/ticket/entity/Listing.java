package com.delogic.ticket.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "listings")
public class Listing {

    @Id
    @Column(name = "listing_id")
    private Long id;
    @OneToOne
    @JoinColumn(name = "seller_id", referencedColumnName = "user_id")
    private User seller;
    @OneToOne
    @JoinColumn(name = "event_id", referencedColumnName = "event_id")
    private Event event;
    private Integer numberOfTickets;
    private BigDecimal pricePerTicket;
    private BigDecimal totalPrice;
    private LocalDateTime listingTimestamp;
}
