package com.elcom.library.service.impl.lib;

import com.elcom.library.entity.lib.Author;
import com.elcom.library.repository.dto.AuthorCustom;
import com.elcom.library.repository.AuthorRepository;
import com.elcom.library.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorServiceImpl implements AuthorService {
    @Autowired
    private AuthorRepository repository;

    @Override
    public List<Author> getAuthor() {
        return repository.findAll();
    }

    @Override
    public Author getAuthorById(int id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public List<AuthorCustom> listBook(){
        return repository.findNumOfBook();
    }

    @Override
    public Author saveAuthor(Author author) {
        return repository.save(author);
    }

    @Override
    public Author updateAuthor(Author author) {
        Author existAuthor = repository.findById(author.getId()).orElse(null);
        existAuthor.setName(author.getName());
        existAuthor.setDob(author.getDob());
        return repository.save(existAuthor);
    }

    @Override
    public String deleteAuthor(int id) {
        repository.deleteById(id);
        return "Delete Success";
    }
}
