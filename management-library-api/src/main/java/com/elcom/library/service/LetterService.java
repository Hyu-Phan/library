package com.elcom.library.service;

import com.elcom.library.entity.lib.Letter;
import com.elcom.library.dto.LetterCustom;

import java.util.List;

public interface LetterService {
    List<Letter> getLetters();

    Letter getLetterById(int id);

    Letter saveLetter(Letter letter);

    Letter updateLetter(Letter letter);

    String deleteLetter(int id);

    List<LetterCustom> listBook();
}
