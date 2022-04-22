package com.elcom.library.service;

import com.elcom.library.entity.lib.Book;
import com.elcom.library.entity.lib.model.BookModel;
import com.elcom.library.repository.elasticsearch.BookElasticRepository;
import com.elcom.library.repository.lib.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@EnableScheduling
public class ElasticSync {
    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private BookElasticRepository bookElasticRepository;

    @Scheduled(cron = "0 */2 * * * *")
    private void sync() {
        List<Book> books = bookRepository.findAll();
        List<BookModel> bookModels = books.stream().map(book -> new BookModel(book)).collect(Collectors.toList());
        bookElasticRepository.saveAll(bookModels);
    }
}
