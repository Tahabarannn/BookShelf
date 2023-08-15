package com.example.BookShelf.api;

import com.example.BookShelf.dto.BookListItemResponse;
import com.example.BookShelf.dto.BookResponse;
import com.example.BookShelf.dto.BookSaveRequest;
import com.example.BookShelf.dto.CategoryType;
import com.example.BookShelf.model.BookStatus;
import com.example.BookShelf.service.BookListService;
import com.example.BookShelf.service.BookSaveService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/v1/book")
@RestController
@RequiredArgsConstructor
public class BookRestController {

    private final BookListService bookListService;
    private final BookSaveService bookSaveService;

    @PostMapping(name = "/save")
    public ResponseEntity<BookListItemResponse> saveBook(@RequestBody BookSaveRequest request){
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(bookSaveService.saveBook(request));
    }

    @GetMapping(name = "/search")
    public ResponseEntity<List<BookResponse>> listBooks(
            @RequestParam(name = "size") int size, @RequestParam(name = "page") int page){
        return ResponseEntity.ok(bookListService.listBooks(size, page));
    }

    @GetMapping(name = "/list/{CategoryType}")
    public ResponseEntity<List<BookResponse>> listByCategory(@PathVariable CategoryType categoryType){
        return ResponseEntity.ok(bookListService.searchByCategory(categoryType));
    }

    @GetMapping(name = "/list/{status}")
    public ResponseEntity<List<BookResponse>> listByCategory(@PathVariable BookStatus status){
        return ResponseEntity.ok(bookListService.searchBookStatus(status));
    }

    @GetMapping(name = "/list/{title}")
    public ResponseEntity<List<BookResponse>> listByCategory(@PathVariable String title){
        return ResponseEntity.ok(bookListService.searchByTitle(title));
    }


}
