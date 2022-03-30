package com.elcom.library.controller;

import com.elcom.library.entity.Author;
import com.elcom.library.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AuthorController {
    @Autowired
    private AuthorService authorService;

    @GetMapping("/author")
    public ResponseEntity<?> findAuthors(){
        List<Author> authors = authorService.getAuthor();
        return ResponseEntity.ok(authors);
    }
}
