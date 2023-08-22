package com.example.BookShelf.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Entity
@Table(name = "images")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Image extends BaseEntity {

    private String imageUrl;
}
