package com.example.BookShelf.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Entity
@Table(name = "category")
@Builder (toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Category extends BaseEntity{
    private String name;

    @OneToMany(mappedBy = "category")
    @JsonIgnore
    private List<Book> books;
}