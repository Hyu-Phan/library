package com.elcom.library.service;

import com.elcom.library.dto.BookBorrowed;
import com.elcom.library.entity.lib.Borrowed;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;

@Service
public interface BorrowedService {

    Borrowed addBorrowed(Long user_id, int book_id);

    List<BookBorrowed> listBookByUser(Date start, Date end, Long user_id);

    List<BookBorrowed> listBookByTime(Date start, Date end);

    BookBorrowed findTheMostBook(Date start, Date end);
}
