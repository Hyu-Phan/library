package com.elcom.library.repository;

import com.elcom.library.entity.Letter;
import com.elcom.library.model.dto.LetterCustom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface LetterRepository extends JpaRepository<Letter, Integer> {
    @Query(value = "select l.name as letter, count(b.id) as numOfBook " +
            "from letter l " +
            "left outer join book b " +
            "on l.id = b.letter_id " +
            "group by l.name", nativeQuery = true)
    List<LetterCustom> findNumOfBook();
}
