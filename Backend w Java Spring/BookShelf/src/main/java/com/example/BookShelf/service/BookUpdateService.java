package com.example.BookShelf.service;

import com.example.BookShelf.dto.BookListItemResponse;
import com.example.BookShelf.dto.ErrorCode;
import com.example.BookShelf.dto.request.BookUpdateRequest;
import com.example.BookShelf.exception.GenericException;
import com.example.BookShelf.model.Book;
import com.example.BookShelf.model.Image;
import com.example.BookShelf.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class BookUpdateService {
    private final ImageStoreService imageStoreService;
    private final BookRepository bookRepository;

    @Transactional(rollbackOn = Exception.class)
    public BookListItemResponse updateBook(BookUpdateRequest updateRequest) {
        final Long id = updateRequest.getId();
        final Book book = bookRepository.findById(id).orElseThrow(() -> GenericException.builder().errorCode(ErrorCode.BOOK_NOT_FOUND).build());

        updateAttributes(updateRequest, book);

        if (updateRequest.getImage() != null) {
            imageStoreService.deleteImg(id);
            book.setImage(new Image(imageStoreService.uploadImg(updateRequest.getImage(), id)));
        }

        bookRepository.save(book);

        return BookListItemResponse.from(book);
    }

    private static void updateAttributes(BookUpdateRequest updateRequest, Book book) {
        book.setAuthor(getOrDefault(updateRequest.getAuthorName(), book.getAuthor()));
        book.setStatus(getOrDefault(updateRequest.getBookStatus(), book.getStatus()));
        book.setLastPageNumber(getOrDefault(updateRequest.getLastPageNumber(), book.getLastPageNumber()));
        book.setPublisher(getOrDefault(updateRequest.getPublisher(), book.getPublisher()));
        book.setTitle(getOrDefault(updateRequest.getTitle(), book.getTitle()));
        book.setTotalPages(getOrDefault(updateRequest.getTotalPage(), book.getTotalPages()));
    }

    private static <T> T getOrDefault(T data, T defaultValue) {
        return data == null ? defaultValue : data;
    }
}