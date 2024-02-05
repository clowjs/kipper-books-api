package com.example.apiexemplo.controllers;

import com.example.apiexemplo.domain.Book;
import com.example.apiexemplo.services.BookService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookController {

    private final BookService bookService;

    private BookController(BookService service) {
        this.bookService = service;
    }

    @GetMapping
    public ResponseEntity<List<Book>> getBooks() {
        List<Book> books = this.bookService.getBooksFromLibrary();
        System.out.println(books);
        return ResponseEntity.ok().body(books);
    }
}
