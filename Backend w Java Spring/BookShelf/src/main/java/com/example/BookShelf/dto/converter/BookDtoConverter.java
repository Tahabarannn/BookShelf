package com.example.BookShelf.dto.converter;

import com.example.BookShelf.dto.BookListItemResponse;
import com.example.BookShelf.dto.request.SaveBookRequest;
import com.example.BookShelf.model.Book;
import com.example.BookShelf.model.Category;

public class BookDtoConverter {

    public static Book convertToBookDto(SaveBookRequest request, Category category, Long userId) {
        return Book.builder()
                .category(category)
                .status(request.getBookStatus())
                .title(request.getTitle())
                .publisher(request.getPublisher())
                .lastPageNumber(request.getLastPageNumber())
                .author(request.getAuthorName())
                .totalPages(request.getTotalPage())
                .userId(userId)
                .build();
    }

    public static BookListItemResponse toItem(Book fromDb) {
        return BookListItemResponse.builder()
                .categoryName(fromDb.getCategory().getName())
                .bookId(fromDb.getId())
                .status(fromDb.getStatus())
                .publisher(fromDb.getPublisher())
                .author(fromDb.getAuthor())
                .totalPages(fromDb.getTotalPages())
                .lastPageNumber(fromDb.getLastPageNumber())
                .title(fromDb.getTitle())
                .userId(fromDb.getUserId())
                .build();
    }
}
