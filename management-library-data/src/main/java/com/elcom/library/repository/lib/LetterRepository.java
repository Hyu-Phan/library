package com.elcom.library.repository.lib;

import com.elcom.library.entity.lib.Letter;
import com.elcom.library.dto.LetterCustom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LetterRepository extends JpaRepository<Letter, Integer> {
    @Query(value = "select l.name as letter, count(b.id) as numOfBook " +
            "from letter l " +
            "left outer join book b " +
            "on l.id = b.letter_id " +
            "group by l.name", nativeQuery = true)
    List<LetterCustom> findNumOfBook();
}
