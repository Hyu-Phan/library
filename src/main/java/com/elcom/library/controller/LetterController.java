package com.elcom.library.controller;

import com.elcom.library.entity.Letter;
import com.elcom.library.service.LetterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/letter")
public class LetterController {
    @Autowired
    private LetterService letterService;

    @GetMapping("")
    public ResponseEntity<?> findLetters(){
        return ResponseEntity.ok(letterService.getLetters());
    }

    @GetMapping("{id}")
    public ResponseEntity<?> findLetterById(@PathVariable int id){
        return ResponseEntity.ok(letterService.getLetterById(id));
    }
    @PostMapping("")
    public ResponseEntity<?> addLetter(@RequestBody Letter letter){
        return ResponseEntity.ok(letterService.saveLetter(letter));
    }

    @PutMapping("")
    public ResponseEntity<?> editLetter(@RequestBody Letter letter){
        return ResponseEntity.ok(letterService.updateLetter(letter));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> deleteLetter(@PathVariable int id){
        return ResponseEntity.ok(letterService.deleteLetter(id));
    }

    @GetMapping("/list")
    public ResponseEntity<?> listOfBook(){
        return ResponseEntity.ok(letterService.listBook());
    }
}
