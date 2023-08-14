package com.example.BookShelf.service;

import com.example.BookShelf.model.Category;
import com.example.BookShelf.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public Category loadCategory(Long id) {
       return categoryRepository.findById(id).orElseThrow();
    }

    public Category findByCategoryName(String categoryName) {
        return categoryRepository.findByCategoryName(categoryName)
                 .orElseThrow(() -> new RuntimeException("Category not found"));
    }
}
