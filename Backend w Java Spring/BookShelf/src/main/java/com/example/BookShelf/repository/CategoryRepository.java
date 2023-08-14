package com.example.BookShelf.repository;

import com.example.BookShelf.model.Book;
import com.example.BookShelf.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.Optional;

public interface CategoryRepository extends JpaRepository<Category, Long>, JpaSpecificationExecutor<Book> {
    Optional<Category> findByCategoryName(String categoryName);
}
