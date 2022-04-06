package com.elcom.library.controller.lib;

import com.elcom.library.entity.lib.Category;
import com.elcom.library.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
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

    @PostMapping("")
    public ResponseEntity<?> addCate(@RequestBody Category cate){
        return ResponseEntity.ok(categoryService.saveCate(cate));
    }

    @PutMapping("")
    public ResponseEntity<?> editCate(@RequestBody Category cate){
        return ResponseEntity.ok(categoryService.updateCate(cate));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCate(@PathVariable int id){
        return ResponseEntity.ok(categoryService.deleteCate(id));
    }

    @GetMapping("/list")
    public ResponseEntity<?> listOfBook(){
        return ResponseEntity.ok(categoryService.listBook());
    }
}
