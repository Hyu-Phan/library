package com.elcom.library.service.impl.lib;

import com.elcom.library.entity.lib.Category;
import com.elcom.library.dto.CategoryCustom;
import com.elcom.library.repository.lib.CategoryRepository;
import com.elcom.library.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryRepository repository;

    @Override
    public List<Category> getCate() {
        return repository.findAll();
    }

    @Override
    public Category getCateById(int id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public Category saveCate(Category category) {
        return repository.save(category);
    }

    @Override
    public Category updateCate(Category category) {
        return repository.save(category);
    }

    @Override
    public String deleteCate(int id) {
        repository.deleteById(id);
        return "Delete Success";
    }

    @Override
    public List<CategoryCustom> listBook() {
        return repository.findNumOfBook();
    }
}
