package com.elcom.library.service.impl.lib;

import com.elcom.library.entity.lib.Letter;
import com.elcom.library.repository.dto.LetterCustom;
import com.elcom.library.repository.LetterRepository;
import com.elcom.library.service.LetterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LetterServiceImpl implements LetterService {
    @Autowired
    private LetterRepository letterRepository;
    @Override
    public List<Letter> getLetters() {
        return letterRepository.findAll();
    }

    @Override
    public Letter getLetterById(int id){
        return letterRepository.findById(id).orElse(null);
    }

    @Override
    public Letter saveLetter(Letter letter) {
        return letterRepository.save(letter);
    }

    @Override
    public Letter updateLetter(Letter letter) {
        return letterRepository.save(letter);
    }

    @Override
    public String deleteLetter(int id) {
        letterRepository.deleteById(id);
        return "Delete Success";

    }

    @Override
    public List<LetterCustom> listBook() {
        return letterRepository.findNumOfBook();
    }
}
