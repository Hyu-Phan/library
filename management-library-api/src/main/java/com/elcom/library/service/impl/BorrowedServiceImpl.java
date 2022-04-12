package com.elcom.library.service.impl;

import com.elcom.library.dto.BookBorrowed;
import com.elcom.library.entity.auth.Borrowed;
import com.elcom.library.entity.auth.User;
import com.elcom.library.entity.lib.Book;
import com.elcom.library.repository.auth.BorrowedRepository;
import com.elcom.library.repository.auth.UserRepository;
import com.elcom.library.repository.lib.BookRepository;
import com.elcom.library.service.BorrowedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;

@Service
public class BorrowedServiceImpl implements BorrowedService {
    @Autowired
    private BorrowedRepository borrowedRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BookRepository bookRepository;

    @Override
    public List<Borrowed> getBorrowed() {
        return borrowedRepository.findAll();
    }

    @Override
    public Borrowed addBorrowed(Long user_id, int book_id) {
        User user = userRepository.findById(user_id).orElse(null);
        Book book = bookRepository.findById(book_id).orElse(null);
        Borrowed borrowed = new Borrowed(user, book);
        return borrowedRepository.save(borrowed);
    }

    @Override
    public List<BookBorrowed> listBookByUser(Long user_id) {
        return borrowedRepository.findBookBorrowedByUser(user_id);
    }

    @Override
    public List<BookBorrowed> listBookByTime(Date start, Date end) {
        return borrowedRepository.listBookBorrowedByTime(start, end);
    }
    @Override
    public BookBorrowed findTheMostBook(Date start, Date end) {
        return borrowedRepository.theMostBorrowedBook(start,end);
    }


}
