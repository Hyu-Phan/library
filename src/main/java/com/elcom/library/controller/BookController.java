package com.elcom.library.controller;

import com.elcom.library.entity.Book;
import com.elcom.library.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("")
public class BookController {
    @Autowired
    private BookService bookService;

    @PostMapping("/add")
    public Book addBook(Book book){
        return  bookService.saveBook(book);
    }

    @GetMapping("/book")
    public ResponseEntity<?> findAllBooks(){
        List<Book> books = bookService.getBooks();
        return ResponseEntity.ok(books);
    }

}
