package com.elcom.library.service.impl;

import com.elcom.library.entity.lib.Book;
import com.elcom.library.repository.lib.BookRepository;
import com.elcom.library.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BookServiceImpl implements BookService {
    @Autowired
    private BookRepository bookRepository;

    @Override
    public Book saveBook(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public List<Book> getBooks() {
        return bookRepository.findAll();
    }

    @Override
    public Book getBookById(int id) {
        return bookRepository.findById(id).orElse(null);
    }

    @Override
    public Book getBookByName(String name) {
        return bookRepository.findByName(name);
    }

    @Override
    public Book updateBook(Book book) {
        Book existBook = bookRepository.findById(book.getId()).orElse(null);
        existBook.setName(book.getName());
        existBook.setTime(book.getTime());
        return bookRepository.save(existBook);
    }

    @Override
    public String deleteBook(int id) {
        bookRepository.deleteById(id);
        return "Delete success";
    }
}
