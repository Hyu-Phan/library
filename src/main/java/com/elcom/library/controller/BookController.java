package com.elcom.library.controller;

import com.elcom.library.entity.Author;
import com.elcom.library.entity.Book;
import com.elcom.library.entity.Category;
import com.elcom.library.entity.Letter;
import com.elcom.library.service.AuthorService;
import com.elcom.library.service.BookService;
import com.elcom.library.service.CategoryService;
import com.elcom.library.service.LetterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {
    @Autowired
    private BookService bookService;

    @Autowired
    private AuthorService authorService;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private LetterService letterService;

    public BookController() {
    }

    @PostMapping("")
    public Book addBook(@RequestBody Book book){
        return  bookService.saveBook(book);
    }

    @GetMapping("")
    public ResponseEntity<?> findAllBooks(){
        List<Book> books = bookService.getBooks();
        return ResponseEntity.ok(books);
    }

    @GetMapping("{id}")
    public ResponseEntity<?> findBookById(@PathVariable int id){
        return ResponseEntity.ok(bookService.getBookById(id));
    }

    @PutMapping("")
    public ResponseEntity<?> updateBook(@RequestBody Book book){
        return ResponseEntity.ok(bookService.updateBook(book));
    }

    @PutMapping("/{book_id}/author/{author_id}")
    public ResponseEntity<?> addAuthorToBook(@PathVariable int book_id, @PathVariable int author_id){
        Author author = authorService.getAuthorById(author_id);
        Book book = bookService.getBookById(book_id);
        book.setAuthor(author);
        return ResponseEntity.ok(bookService.saveBook(book));
    }

    @PutMapping("/{book_id}/category/{cate_id}")
    public ResponseEntity<?> addCategoryToBook(@PathVariable int book_id, @PathVariable int cate_id){
        Category category = categoryService.getCateById(cate_id);
        Book book = bookService.getBookById(book_id);
        book.setCategory(category);
        return ResponseEntity.ok(bookService.saveBook(book));
    }

    @PutMapping("/{book_id}/letter/{letter_id}")
    public ResponseEntity<?> addLetterToBook(@PathVariable int book_id, @PathVariable int letter_id){
        Letter letter = letterService.getLetterById(letter_id);
        Book book = bookService.getBookById(book_id);
        book.setLetter(letter);
        return ResponseEntity.ok(bookService.saveBook(book));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteBook(@PathVariable int id){
        return ResponseEntity.ok(bookService.deleteBook(id));
    }
}
