package com.elcom.library.repository.auth;

import com.elcom.library.dto.BookBorrowed;
import com.elcom.library.entity.auth.Borrowed;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;

@Repository
public interface BorrowedRepository extends JpaRepository<Borrowed, Long> {
    @Query(value = "select b.name as name, count(*) as number " +
                    "from borrowed br join book b on br.book_id = b.id " +
                    "where br.user_id = :userId " +
                    "group by b.id", nativeQuery = true)
    public List<BookBorrowed> findBookBorrowedByUser(Long userId);

    @Query(value = "select b.name as name, count(*) as number " +
            "from borrowed br join book b on br.book_id = b.id " +
            "where br.date >= :date1 and br.date <= :date2 " +
            "group by b.id", nativeQuery = true)
    public List<BookBorrowed> listBookBorrowedByTime(Date date1, Date date2);

    @Query(value = "select b.name as name, count(*) as number " +
            "from borrowed br join book b on br.book_id = b.id " +
            "where br.date >= :date1 and br.date <= :date2 " +
            "group by b.id " +
            "order by number desc " +
            "limit 1", nativeQuery = true)
    public BookBorrowed theMostBorrowedBook(Date date1, Date date2);
}
