package com.elcom.library.service;

import com.elcom.library.entity.lib.Book;
import org.springframework.stereotype.Service;

import java.util.List;

public interface BookService {
    Book saveBook(Book book);

    List<Book> getBooks();

    Book getBookById(int id);

    Book getBookByName(String name);

    Book updateBook(Book book);

    String deleteBook(int id);
}
