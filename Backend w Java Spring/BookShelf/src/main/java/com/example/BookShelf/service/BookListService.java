package com.example.BookShelf.service;

import com.example.BookShelf.dto.BookResponse;
import com.example.BookShelf.repository.BookRepository;
import org.springframework.data.domain.PageRequest;

import java.util.List;
import java.util.stream.Collectors;

public class BookListService {
    private CategoryService categoryService;
    private BookRepository bookRepository;

    public List<BookResponse> listBooks(BookSearchRequest searchRequest) {
        return bookRepository.findAll(PageRequest.of(searchRequest.getPage(), searchRequest.getSize()))
                .getContent()
                .stream()
                .map(model -> BookResponse.builder()
                        .title(model.getTitle())
                        .author(model.getAuthor())
                        .imageUrl(model.getImage().getImageUrl())
                        .build())
                .collect(Collectors.toList());
    }
}
