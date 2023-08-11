package com.example.BookShelf.dto;

import com.example.BookShelf.model.BookStatus;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.io.File;

@Data
public final class BookSaveRequest {

    @NotBlank
    private String title;
    @NotBlank
    private String author;
    @NotNull
    private BookStatus status;
    @NotBlank
    private String publisher;
    @NotNull
    private Integer lastPageNumber;
    @NotNull
    private Integer totalPageNumber;
    private File image;
    @NotNull
    private Long CategoryId;
}
