package com.delogic.ticket.repository;

import com.delogic.ticket.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepository extends PagingAndSortingRepository<User, Long>, CrudRepository<User, Long> {


    Page<User> findAll(Pageable pageable);

}
