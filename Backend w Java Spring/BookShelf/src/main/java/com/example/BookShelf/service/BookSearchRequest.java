package com.example.BookShelf.service;

import lombok.Data;

@Data
public class BookSearchRequest {
    private int size;
    private int page;
}
