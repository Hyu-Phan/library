package com.elcom.library.service.impl;

import com.elcom.library.entity.lib.Book;
import com.elcom.library.entity.lib.model.BookModel;
import com.elcom.library.repository.elasticsearch.BookElasticRepository;
import com.elcom.library.repository.lib.BookRepository;
import com.elcom.library.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Component
public class BookServiceImpl implements BookService {
    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private BookElasticRepository bookElasticRepository;

    @Override
    public Book saveBook(Book book) {
        Book bookNew = bookRepository.save(book);
        BookModel bookModel = new BookModel(bookNew);
        bookElasticRepository.save(bookModel);
        return bookNew;
    }

    @Override
    public List<BookModel> getBooks() {
        List<BookModel> books = new ArrayList<>();
        for(BookModel book : bookElasticRepository.findAll()){
            books.add(book);
        }
        return books;
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
        bookElasticRepository.save(new BookModel(existBook));
        return bookRepository.save(existBook);
    }

    @Override
    public String deleteBook(int id) {
        bookRepository.deleteById(id);
        bookElasticRepository.deleteById(String.valueOf(id));
        return "Delete success";
    }

    @Override
    public BookModel getBookModelById(int id) {
        return (BookModel) bookElasticRepository.findById(String.valueOf(id)).orElse(null);
    }
}
