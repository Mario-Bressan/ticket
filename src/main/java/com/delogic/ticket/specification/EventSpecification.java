package com.delogic.ticket.specification;

import com.delogic.ticket.entity.Event;
import com.delogic.ticket.entity.EventDate;
import com.delogic.ticket.entity.Sale;
import com.delogic.ticket.entity.Venue;
import jakarta.persistence.criteria.*;
import org.springframework.data.jpa.domain.Specification;

import java.time.LocalDate;


public class EventSpecification implements Specification<Event> {
    private final LocalDate eventDate;
    private final Long categoryId;
    private final String city;

    public EventSpecification(LocalDate date, Long categoryId, String city) {
        this.eventDate = date;
        this.categoryId = categoryId;
        this.city = city;
    }


    @Override
    public Predicate toPredicate(Root<Event> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
        Join<Event, EventDate> dateJoin = root.join("date");
        Predicate datePredicate = criteriaBuilder.lessThanOrEqualTo(dateJoin.get("calendarDate"), eventDate);

        Predicate categoryPredicate = criteriaBuilder.conjunction();
        if (categoryId != null) {
            categoryPredicate = criteriaBuilder.equal(root.get("category").get("id"), categoryId);
        }

        Predicate cityPredicate = criteriaBuilder.conjunction();
        if (city != null && !city.isEmpty()) {
            Join<Event, Venue> venueJoin = root.join("venue");
            cityPredicate = criteriaBuilder.equal(venueJoin.get("city"), city);
        }

        Subquery<Long> subquery = query.subquery(Long.class);
        Root<Sale> saleRoot = subquery.from(Sale.class);
        subquery.select(saleRoot.get("event").get("id"));
        subquery.where(criteriaBuilder.equal(saleRoot.get("event").get("id"), root.get("id")));

        Predicate salePredicate = criteriaBuilder.not(criteriaBuilder.in(root.get("id")).value(subquery));

        return criteriaBuilder.and(datePredicate, categoryPredicate, cityPredicate, salePredicate);
    }


}
