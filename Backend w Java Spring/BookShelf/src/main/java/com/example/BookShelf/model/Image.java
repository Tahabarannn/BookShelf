package com.example.BookShelf.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Entity
@Table(name = "image")
@Getter
@SuperBuilder
@NoArgsConstructor
public class Image extends BaseEntity {

    private String imageUrl;
}
