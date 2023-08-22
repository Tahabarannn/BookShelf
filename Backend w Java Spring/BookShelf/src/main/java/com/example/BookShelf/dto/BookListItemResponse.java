package com.example.BookShelf.dto;

import com.example.BookShelf.model.Book;
import com.example.BookShelf.model.BookStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.io.File;

@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class BookListItemResponse {
    private Long bookId;
    private String title;
    private String author;
    private BookStatus status;
    private String publisher;
    private Integer lastPageNumber;
    private Integer totalPages;
    private File image;
    private String categoryName;
    private Long userId;
    private String imageUrl;

    public static BookListItemResponse from(Book book) {
        return  BookListItemResponse.builder()
                .bookId(book.getId())
                .title(book.getTitle())
                .author(book.getAuthor())
                .status(book.getStatus())
                .publisher(book.getPublisher())
                .lastPageNumber(book.getLastPageNumber())
                .categoryName(book.getCategory().getName())
                .totalPages(book.getTotalPages())
                .userId(book.getUserId())
                .imageUrl(book.getImage() != null ? book.getImage().getImageUrl() : null)
                .build();
    }

}
