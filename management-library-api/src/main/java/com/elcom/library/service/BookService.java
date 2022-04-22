package com.elcom.library.service;

import com.elcom.library.entity.lib.Book;
import com.elcom.library.entity.lib.model.BookModel;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

public interface BookService {
    Book saveBook(Book book);

    List<BookModel> getBooks();

    Book getBookById(int id);

    Book getBookByName(String name);

    Book updateBook(Book book);

    String deleteBook(int id);

    BookModel getBookModelById(int id);
}
