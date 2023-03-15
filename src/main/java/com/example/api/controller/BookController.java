package com.example.api.controller;

import com.example.api.entities.Book;
import com.example.api.models.BookDTO;
import com.example.api.services.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@RestController
public class BookController {
    private final BookService bookService;

    @PostMapping("/library/book")
    public BookDTO createBook(@RequestBody BookDTO bookDTO){
        return bookService.saveNewBook(bookDTO);
    }

    @GetMapping("/library/books")
    public List<BookDTO> getAllBooksSorted(){
        return bookService.getAllBooksSorted();
    }

    @DeleteMapping("/library/book/{bookId}")
    public ResponseEntity deleteBook(@PathVariable("bookId") UUID bookId) {
        bookService.deleteBookById(bookId);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/library/bookByTitle/{title}")
    public BookDTO getBookByTitle(@PathVariable("title") String title){
        return bookService.getBookByTitle(title);
    }

    @PatchMapping("/library/book/{bookId}")
    public BookDTO updateAuthor( @RequestBody BookDTO bookDTO, @PathVariable("bookId") UUID bookId){
        return bookService.updateBookAuthor(bookId, bookDTO);
    }
}
