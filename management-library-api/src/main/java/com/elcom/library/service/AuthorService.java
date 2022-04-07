package com.elcom.library.service;

import com.elcom.library.entity.lib.Author;
import com.elcom.library.dto.AuthorCustom;

import java.util.List;

public interface AuthorService {
    List<Author> getAuthor();

    Author getAuthorById(int id);

    Author saveAuthor(Author author);

    Author updateAuthor(Author author);

    String deleteAuthor(int id);

    List<AuthorCustom> listBook();
}
