package com.example.BookShelf.service;

import com.example.BookShelf.dto.BookListItemResponse;
import com.example.BookShelf.dto.CategoryType;
import com.example.BookShelf.dto.request.SaveBookRequest;
import com.example.BookShelf.dto.UserDto;
import com.example.BookShelf.model.Book;
import com.example.BookShelf.model.BookStatus;
import com.example.BookShelf.model.Category;
import com.example.BookShelf.repository.BookRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

class BookSaveServiceTest extends BaseServiceTest {

    @InjectMocks
    private BookSaveService bookSaveService;
    @Mock
    private BookRepository bookRepository;
    @Mock
    private CategoryService categoryService;
    @Mock
    private UserService userService;
    @Mock
    private CacheClient cacheClient;


    @Test
    void shouldReturnBookListItemResponseWhenNewSaveBook() {
        // given

        BookListItemResponse.builder().status(BookStatus.READING)
                .title("title")
                .userId(1L)
                .categoryName(CategoryType.COMIC.name())
                .build();
        Category category = Category.builder().name(CategoryType.COMIC.getValue()).build();

        final SaveBookRequest saveBookRequest = SaveBookRequest.builder().bookStatus(BookStatus.READING)
                .title("title")
                .userId(1L)
                .categoryId(1L)
                .build();

        Book book = Book.builder().category(category)
                .status(saveBookRequest.getBookStatus())
                .title(saveBookRequest.getTitle())
                .publisher(saveBookRequest.getPublisher())
                .lastPageNumber(saveBookRequest.getLastPageNumber())
                .author(saveBookRequest.getAuthorName())
                .totalPages(saveBookRequest.getTotalPage())
                .userId(saveBookRequest.getUserId())
                .build();

        // when
        when(categoryService.loadCategory(anyLong())).thenReturn(category);
        when(bookRepository.save(any(Book.class))).thenReturn(book);
        when(userService.findUserInContext()).thenReturn(new UserDto());

        // then
        BookListItemResponse bookListItemResponse = bookSaveService.saveBook(saveBookRequest);
        assertEquals(BookStatus.READING, bookListItemResponse.getStatus());
        assertEquals("title", bookListItemResponse.getTitle());
        assertEquals(1L, bookListItemResponse.getUserId());

    }
}