package com.example.BookShelf.service;

import com.example.BookShelf.dto.BookResponse;
import com.example.BookShelf.dto.CategoryType;
import com.example.BookShelf.model.Book;
import com.example.BookShelf.model.BookStatus;
import com.example.BookShelf.model.Category;
import com.example.BookShelf.model.User;
import com.example.BookShelf.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BookListService {
    private final CategoryService categoryService;
    private final BookRepository bookRepository;
    private final AuthService authService;
    private final UserService userService;

    public List<BookResponse> listBooks(int size, int page) {
        return bookRepository.findAll(PageRequest.of(page, size))
                .getContent()
                .stream()
                .map(BookListService::convertResponse)
                .collect(Collectors.toList());
    }

    public List<BookResponse> searchByCategory(CategoryType categoryType) {
        final Category category = categoryService.findByCategoryName(categoryType.getValue());
        return category.getBooks()
                .stream()
                .map(BookListService::convertResponse)
                .collect(Collectors.toList());
    }

    private static BookResponse convertResponse(Book model) {
        return BookResponse.builder()
                .title(model.getTitle())
                .author(model.getAuthor())
                .imageUrl(model.getImage().getImageUrl())
                .build();
    }

    public List<BookResponse> searchBookStatus(BookStatus bookStatus){
        User user = userService.findUserByUsername(authService.getLoggedInUsername());
        return bookRepository.findByBookStatus(bookStatus)
                .stream()
                .map(each ->
                    BookResponse.builder()
                        .id(each.getId())
                        .imageUrl(each.getImage().getImageUrl())
                        .build()
                )
                .collect(Collectors.toList());
    }

    public List<BookResponse> searchByTitle(String title){
        return bookRepository.findByTitle(title)
                .stream()
                .map(each ->
                        BookResponse.builder()
                                .id(each.getId())
                                .imageUrl(each.getImage().getImageUrl())
                                .build()
                )
                .collect(Collectors.toList());
    }
}
