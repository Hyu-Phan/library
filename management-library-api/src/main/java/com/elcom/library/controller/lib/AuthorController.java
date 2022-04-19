package com.elcom.library.controller.lib;

import com.elcom.library.entity.lib.Author;
import com.elcom.library.service.AuthorService;
import org.hibernate.annotations.Cache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/author")
public class AuthorController {
    @Autowired
    private AuthorService authorService;

    @GetMapping("")
    public ResponseEntity<?> findAuthors(){
        List<Author> authors = authorService.getAuthor();
        return ResponseEntity.ok(authors);
    }

    @GetMapping("/{author_id}")
    public Author findAuthorById(@PathVariable int author_id){
        return authorService.getAuthorById(author_id);
    }

    @GetMapping("/list")
    public ResponseEntity<?> listOfBook(){
        return ResponseEntity.ok(authorService.listBook());
    }

    @PostMapping("")
    public ResponseEntity<?> addAuthor(@RequestBody Author author){
        return ResponseEntity.ok(authorService.saveAuthor(author));
    }

    @PutMapping("")
    public ResponseEntity<?> editAuthor(@RequestBody Author author){
        return ResponseEntity.ok(authorService.updateAuthor(author));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteAuthor(@PathVariable int id){
        return ResponseEntity.ok(authorService.deleteAuthor(id));
    }
}
