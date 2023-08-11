package com.example.BookShelf.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Entity
@Table(name = "category")
@SuperBuilder
@NoArgsConstructor
@Getter
public class Category extends BaseEntity{
    private String name;

    @OneToMany(mappedBy = "category")
    @JsonIgnore
    private List<Book> books;
}