package com.turkcell.spring.starter.controllers;

import com.turkcell.spring.starter.entities.Category;
import com.turkcell.spring.starter.services.abstracts.CategoryService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
public class CategoriesController {

    private final CategoryService categoryService;

    public CategoriesController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping
    public List<Category> getAll(){
        return categoryService.getAll();
    }

    @PostMapping
    public String post()
    {
        return "Merhaba";
    }
}
