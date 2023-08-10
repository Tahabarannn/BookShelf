package com.example.BookShelf.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "book")
@Getter
@NoArgsConstructor
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String author;

    @Enumerated(value = EnumType.STRING)
    private BookStatus status;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;
}
