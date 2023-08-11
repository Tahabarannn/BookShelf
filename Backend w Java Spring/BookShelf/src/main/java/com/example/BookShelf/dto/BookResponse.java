package com.example.BookShelf.dto;

import com.example.BookShelf.model.BookStatus;
import lombok.Data;
import lombok.experimental.SuperBuilder;

import java.io.File;

@Data
@SuperBuilder
public class BookResponse {
    private String title;
    private String author;
    private BookStatus status;
    private String publisher;
    private Integer lastPageNumber;
    private Integer totalPages;
    private File image;
    private Long CategoryId;
    private String imageUrl;
}
