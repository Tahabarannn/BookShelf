package com.example.BookShelf.service;

import com.example.BookShelf.dto.ErrorCode;
import com.example.BookShelf.exception.GenericException;
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
        return categoryRepository.findById(id).orElseThrow(() -> GenericException.builder().errorCode(ErrorCode.CATEGORY_NOT_FOUND).build());
    }

    public Category findByName(String value) {
        return categoryRepository.findByName(value).orElseThrow(() -> GenericException.builder().errorCode(ErrorCode.CATEGORY_NOT_FOUND).build());
    }
}