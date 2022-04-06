package com.elcom.library.repository;

import com.elcom.library.entity.lib.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {
    Book findByName(String name);

}
