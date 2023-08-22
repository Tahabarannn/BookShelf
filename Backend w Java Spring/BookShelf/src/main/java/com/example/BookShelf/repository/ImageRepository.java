package com.example.BookShelf.repository;

import com.example.BookShelf.model.Image;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImageRepository extends JpaRepository<Image, Long> {
}