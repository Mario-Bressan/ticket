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
@Table(name = "sales")
public class Sale {

    @Id
    @Column(name = "sale_id")
    private Long id;
    @OneToOne
    @JoinColumn(name = "listing_id", referencedColumnName = "listing_id")
    private Listing listing;
    @OneToOne
    @JoinColumn(name = "seller_id", referencedColumnName = "user_id")
    private User seller;
    @OneToOne
    @JoinColumn(name = "buyer_id", referencedColumnName = "user_id")
    private User buyer;
    @OneToOne
    @JoinColumn(name = "date_id", referencedColumnName = "date_id")
    private Date date;
    private Integer quantitySold;
    private BigDecimal pricePaid;
    private BigDecimal commission_amount;
    private LocalDateTime saleTimestamp;

}
