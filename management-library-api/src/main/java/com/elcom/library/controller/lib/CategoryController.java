package com.elcom.library.controller.lib;

import com.elcom.library.entity.lib.Author;
import com.elcom.library.entity.lib.Category;
import com.elcom.library.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("category")

public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @GetMapping("")
    public ResponseEntity<?> findCategories(){
        List<Category> categories = categoryService.getCate();
        return ResponseEntity.ok(categories);
    }

    @GetMapping("/{id}")
    public Category findAuthorById(@PathVariable int id){
        return categoryService.getCateById(id);
    }

    @PostMapping("")
    public ResponseEntity<?> addCate(@RequestBody Category cate){
        return ResponseEntity.ok(categoryService.saveCate(cate));
    }

    @PutMapping("")
    public ResponseEntity<?> editCate(@RequestBody Category cate){
        return ResponseEntity.ok(categoryService.updateCate(cate));
    }

    @CacheEvict(value = "category", key = "#id")
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCate(@PathVariable int id){
        return ResponseEntity.ok(categoryService.deleteCate(id));
    }

    @GetMapping("/list")
    public ResponseEntity<?> listOfBook(){
        return ResponseEntity.ok(categoryService.listBook());
    }
}
