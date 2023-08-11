package com.example.BookShelf.service;

import com.example.BookShelf.model.Category;
import com.example.BookShelf.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public Category loadCategory(Long id) {
       return categoryRepository.findById(id).orElseThrow();
    }
}
