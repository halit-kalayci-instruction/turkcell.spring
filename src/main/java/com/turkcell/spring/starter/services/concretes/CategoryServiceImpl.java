package com.turkcell.spring.starter.services.concretes;

import com.turkcell.spring.starter.entities.Category;
import com.turkcell.spring.starter.repositories.abstracts.CategoryRepository;
import com.turkcell.spring.starter.services.abstracts.CategoryService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<Category> getAll() {
        return categoryRepository.findAll();
    }
}
