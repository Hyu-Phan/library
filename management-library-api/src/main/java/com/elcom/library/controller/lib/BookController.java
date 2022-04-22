package com.elcom.library.controller.lib;

import com.elcom.library.entity.lib.Author;
import com.elcom.library.entity.lib.Book;
import com.elcom.library.entity.lib.Category;
import com.elcom.library.entity.lib.Letter;
import com.elcom.library.entity.lib.model.BookModel;
import com.elcom.library.service.AuthorService;
import com.elcom.library.service.BookService;
import com.elcom.library.service.CategoryService;
import com.elcom.library.service.LetterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book")
@PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
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
    public ResponseEntity<?> addBook(@RequestBody Book book){
        return ResponseEntity.ok(bookService.saveBook(book));
    }

    @GetMapping("")
    public ResponseEntity<?> findAllBooks(){
        return ResponseEntity.ok(bookService.getBooks());
    }

    @GetMapping("{id}")
    public ResponseEntity<?> findBookById(@PathVariable int id){
        return ResponseEntity.ok(bookService.getBookModelById(id));
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
//        return ResponseEntity.ok(bookService.saveBook(book));
        return null;
    }

    @PutMapping("/{book_id}/category/{cate_id}")
    public ResponseEntity<?> addCategoryToBook(@PathVariable int book_id, @PathVariable int cate_id){
        Category category = categoryService.getCateById(cate_id);
        Book book = bookService.getBookById(book_id);
        book.setCategory(category);
//        return ResponseEntity.ok(bookService.saveBook(book));
        return null;
    }

    @PutMapping("/{book_id}/letter/{letter_id}")
    public ResponseEntity<?> addLetterToBook(@PathVariable int book_id, @PathVariable int letter_id){
        Letter letter = letterService.getLetterById(letter_id);
        Book book = bookService.getBookById(book_id);
        book.setLetter(letter);
//        return ResponseEntity.ok(bookService.saveBook(book));
        return null;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteBook(@PathVariable int id){
        return ResponseEntity.ok(bookService.deleteBook(id));
    }
}
