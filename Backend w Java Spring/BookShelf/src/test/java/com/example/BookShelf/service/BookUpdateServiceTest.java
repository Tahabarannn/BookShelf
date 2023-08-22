package com.example.BookShelf.service;

import com.example.BookShelf.dto.*;
import com.example.BookShelf.dto.request.BookUpdateRequest;
import com.example.BookShelf.model.Book;
import com.example.BookShelf.model.BookStatus;
import com.example.BookShelf.model.Category;
import com.example.BookShelf.repository.BookRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

public class BookUpdateServiceTest extends BaseServiceTest {

    @InjectMocks
    private BookUpdateService bookUpdateService;

    @Mock
    private BookRepository bookRepository;


    @Test
    void givenBook_whenUpdateBook_thenReturnUpdatedBook() {

        // given - precondition or setup
        BookListItemResponse bookListItemResponse = BookListItemResponse.builder().status(BookStatus.READING)
                .title("Updated title")
                .userId(1L)
                .bookId(1L)
                .categoryName(CategoryType.COMIC.name())
                .build();

        Category category = Category.builder().name(CategoryType.COMIC.name()).build();

        BookUpdateRequest updatedBookRequest = new BookUpdateRequest();
        updatedBookRequest.setTitle("Updated title");
        updatedBookRequest.setId(1L);
        updatedBookRequest.setCategoryId(1L);

        Book book = Book.builder().category(category)
                .title(updatedBookRequest.getTitle())
                .userId(1L)
                .build();

        // when -  action or the behaviour that we are going test
        when(bookRepository.findById(1L)).thenReturn(Optional.of(book));
        when(bookRepository.save(any(Book.class))).thenReturn(book);

        // then - verify the output
        BookListItemResponse resultBookListItemResponse = bookUpdateService.updateBook(updatedBookRequest);
        assertEquals(bookListItemResponse.getTitle(), resultBookListItemResponse.getTitle());
        assertEquals(bookListItemResponse.getCategoryName(), resultBookListItemResponse.getCategoryName());
    }
}