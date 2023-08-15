package com.example.BookShelf.service;

import com.example.BookShelf.dto.BookListItemResponse;
import com.example.BookShelf.dto.BookSaveRequest;
import com.example.BookShelf.model.Book;
import com.example.BookShelf.model.Category;
import com.example.BookShelf.repository.BookRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class BookSaveService {
    private final BookRepository bookRepository;
    private final CategoryService categoryService;

    @Transactional
    public BookListItemResponse saveBook(BookSaveRequest bookSaveRequest) {
        Category category = categoryService.loadCategory(bookSaveRequest.getCategoryId());
        final Book book = Book.builder()
                .category(category)
                .title(bookSaveRequest.getTitle())
                .author(bookSaveRequest.getAuthor())
                .publisher(bookSaveRequest.getPublisher())
                .status(bookSaveRequest.getStatus())
                .lastPageNumber(bookSaveRequest.getLastPageNumber())
                .totalPages(bookSaveRequest.getTotalPageNumber())
                .build();
        final Book fromDb = bookRepository.save(book);
        return BookListItemResponse.builder()
                .categoryName(book.getCategory().getName())
                .bookId(book.getId())
                .title(book.getTitle())
                .status(book.getStatus())
                .publisher(book.getPublisher())
                .author(book.getAuthor())
                .totalPages(book.getTotalPages())
                .lastPageNumber(book.getLastPageNumber())
                .build();
    }
}
