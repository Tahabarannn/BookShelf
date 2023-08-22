package com.example.BookShelf.model;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Entity
@Table(name = "book")
@Getter
@Setter
@NoArgsConstructor
@Builder (toBuilder = true)
@AllArgsConstructor
public class Book extends BaseEntity{
    private String title;
    private String author;

    @Enumerated(EnumType.STRING)
    private BookStatus status;
    private String publisher;
    private Integer lastPageNumber;
    private Integer totalPages;

    @OneToOne
    private Image image;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;
    private Long userId;

    public Image getImage() {
        if (image == null) {
            image = new Image();
        }
        return image;
    }
}
