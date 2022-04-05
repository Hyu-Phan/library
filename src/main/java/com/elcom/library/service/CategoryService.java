package com.elcom.library.service;

import com.elcom.library.entity.lib.Category;
import com.elcom.library.repository.dto.CategoryCustom;

import java.util.List;

public interface CategoryService {
    List<Category> getCate();

    Category getCateById(int id);

    Category saveCate(Category category);

    Category updateCate(Category category);

    String deleteCate(int id);

    List<CategoryCustom> listBook();
}
