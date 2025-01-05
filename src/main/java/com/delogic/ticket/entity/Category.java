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
@Table(name = "categories")
public class Category {

    @Id
    @Column(name = "category_id")
    private Long id;
    @Column(name = "category_group")
    private String group;
    @Column(name = "category_name")
    private String name;
    @Column(name = "category_description")
    private String description;
}
