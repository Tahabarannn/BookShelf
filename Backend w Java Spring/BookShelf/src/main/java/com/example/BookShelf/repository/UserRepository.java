package com.example.BookShelf.repository;

import com.example.BookShelf.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
