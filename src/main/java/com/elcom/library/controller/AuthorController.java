package com.elcom.library.controller;

import com.elcom.library.entity.Author;
import com.elcom.library.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
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
