package com.elcom.library.service.impl;

import com.elcom.library.entity.Author;
import com.elcom.library.repository.AuthorRepository;
import com.elcom.library.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorServiceImpl implements AuthorService {
    @Autowired
    private AuthorRepository authorRepository;
    @Override
    public List<Author> getAuthor() {
        return authorRepository.findAll();
    }
}
