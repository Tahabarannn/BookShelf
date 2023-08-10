package com.example.BookShelf.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Entity
@Table(name = "book")
@Getter
@NoArgsConstructor
@SuperBuilder
public class Book extends BaseEntity{
    private String title;
    private String author;

    @Enumerated(value = EnumType.STRING)
    private BookStatus status;
    private String publisher;
    private Integer lastPageNumber;

    @OneToOne
    private Image image;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;
}
