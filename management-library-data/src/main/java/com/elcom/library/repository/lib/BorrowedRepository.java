package com.elcom.library.repository.lib;

import com.elcom.library.dto.BookBorrowed;
import com.elcom.library.entity.lib.Borrowed;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;

@Repository
public interface BorrowedRepository extends JpaRepository<Borrowed, Long> {

    @Query(value = "select b.name as name, count(*) as number " +
            "from borrowed br join book b on br.book_id = b.id " +
            "where br.date >= :start and br.date <= :end and br.user_id = :userId " +
            "group by b.id", nativeQuery = true)
    public List<BookBorrowed> findBookBorrowedByUser(Date start, Date end, Long userId);

    @Query(value = "select b.name as name, count(*) as number " +
            "from borrowed br join book b on br.book_id = b.id " +
            "where br.date >= :start and br.date <= :end " +
            "group by b.id", nativeQuery = true)
    public List<BookBorrowed> listBookBorrowedByTime(Date start, Date end);

    @Query(value = "select b.name as name, count(*) as number " +
            "from borrowed br join book b on br.book_id = b.id " +
            "where br.date >= :start and br.date <= :end " +
            "group by b.id " +
            "order by number desc " +
            "limit 1", nativeQuery = true)
    public BookBorrowed theMostBorrowedBook(Date start, Date end);
}
