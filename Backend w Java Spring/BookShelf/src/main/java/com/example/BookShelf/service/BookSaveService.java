package com.example.BookShelf.service;

import com.example.BookShelf.dto.BookListItemResponse;
import com.example.BookShelf.dto.ErrorCode;
import com.example.BookShelf.dto.converter.BookDtoConverter;
import com.example.BookShelf.dto.request.SaveBookRequest;
import com.example.BookShelf.exception.GenericException;
import com.example.BookShelf.model.Book;
import com.example.BookShelf.model.Category;
import com.example.BookShelf.model.Image;
import com.example.BookShelf.repository.BookRepository;
import com.example.BookShelf.repository.ImageRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Caching;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class BookSaveService {
    private final BookRepository bookRepository;
    private final CategoryService categoryService;
    private final ImageRepository imageRepository;
    private final UserService userService;
    private final CacheClient cacheClient;

    @Transactional
    @Caching(evict = {
            @CacheEvict(key = "'saveBook_' + #request.userId", value = "bookList"),
    })
    public BookListItemResponse saveBook(SaveBookRequest request) {
        Category category = categoryService.loadCategory(request.getCategoryId());
        final Long userID = userService.findUserInContext().getId();
        final Book book = BookDtoConverter.convertToBookDto(request, category, userID);

        final Book fromDb = bookRepository.save(book);
        evictCache(request);

        return BookDtoConverter.toItem(fromDb);
    }

    @Async
    public void evictCache(SaveBookRequest request) {
        final String statusCache = "status" + request.getBookStatus() + request.getUserId();
        final String saveBookCache = "saveBook_" + request.getUserId();
        cacheClient.deleteAll(List.of(statusCache, saveBookCache));
    }

    public void deleteBook(Long bookId) {
        bookRepository.deleteById(bookId);
    }

    @Transactional
    public void saveImage(Long bookId, String imageUrl) {
        Book book = bookRepository.findById(bookId).orElseThrow(() -> GenericException.builder().errorCode(ErrorCode.BOOK_NOT_FOUND).build());
        final Image image = book.getImage();
        if (image == null) {
            book.setImage(imageRepository.save(Image.builder().imageUrl(imageUrl).build()));
        } else {
            image.setImageUrl(imageUrl);
        }
        bookRepository.save(book);
    }

}

