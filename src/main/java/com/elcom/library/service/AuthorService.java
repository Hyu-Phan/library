package com.elcom.library.service;

import com.elcom.library.entity.Author;
import org.springframework.stereotype.Service;

import java.util.List;

public interface AuthorService {
    List<Author> getAuthor();

    Author getAuthorById(int id);

    Author saveAuthor(Author author);

    Author updateAuthor(Author author);

    String deleteAuthor(int id);
}
