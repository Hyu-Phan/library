package com.elcom.library.service.impl;

import com.elcom.library.entity.lib.Author;
import com.elcom.library.dto.AuthorCustom;
import com.elcom.library.repository.lib.AuthorRepository;
import com.elcom.library.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
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

    @Cacheable(cacheManager = "cacheManager", value = "author", key = "#id")
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

    @CachePut(cacheManager = "cacheManager", value = "author", key = "#author.id")
    @Override
    public Author updateAuthor(Author author) {
        Author existAuthor = repository.findById(author.getId()).orElse(null);
        existAuthor.setName(author.getName());
        existAuthor.setDob(author.getDob());
        return repository.save(existAuthor);
    }

    @CacheEvict(cacheManager = "cacheManager", value = "author", key = "#id")
    @Override
    public String deleteAuthor(int id) {
        repository.deleteById(id);
        return "Delete Success";
    }
}
