package com.delogic.ticket.repository;

import com.delogic.ticket.entity.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends PagingAndSortingRepository<Category, Long>, CrudRepository<Category, Long> {

    Page<Category> findAll(Pageable pageable);
}
