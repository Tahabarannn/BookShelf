package com.example.BookShelf.repository;

import com.example.BookShelf.model.Book;
import com.example.BookShelf.model.BookStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long>, JpaSpecificationExecutor<Book> {
    List<Book> findByBookStatus(BookStatus bookStatus);

}
