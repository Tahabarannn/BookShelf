package com.example.BookShelf.service;

import com.example.BookShelf.repository.BookRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class BookSaveService {
    private final BookRepository bookRepository;
}
