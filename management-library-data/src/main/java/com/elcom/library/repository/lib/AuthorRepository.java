package com.elcom.library.repository.lib;

import com.elcom.library.entity.lib.Author;
import com.elcom.library.dto.AuthorCustom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Integer> {
    @Query(value = "select a.name as author, count(b.id) as numOfBook " +
            "from author a " +
            "left outer join book b " +
            "on a.id = b.author_id " +
            "group by a.name", nativeQuery = true)
    List<AuthorCustom> findNumOfBook();
}
