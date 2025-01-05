package com.delogic.ticket.service;

import com.delogic.ticket.entity.Category;
import com.delogic.ticket.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public Page<Long> findAll(Pageable pageable) {
        return categoryRepository.findAll(pageable)
                .map(Category::getId);
    }
}
