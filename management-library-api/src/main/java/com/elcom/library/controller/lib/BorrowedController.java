package com.elcom.library.controller.lib;

import com.elcom.library.controller.request.TimeBookBorrowed;
import com.elcom.library.entity.lib.Borrowed;
import com.elcom.library.service.BorrowedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/borrowed")
public class BorrowedController {

    @Autowired
    private BorrowedService borrowedService;

    @GetMapping("")
    public ResponseEntity<?> getAllBorrowed() {
        return ResponseEntity.ok(borrowedService.getBorrowed());
    }

    @PostMapping("/{user_id}/{book_id}")
    public ResponseEntity<?> addBorrowed(@PathVariable Long user_id, @PathVariable int book_id){
        Borrowed borrowed = borrowedService.addBorrowed(user_id, book_id);
        return ResponseEntity.ok(borrowed);
    }

    @GetMapping("/user/{user_id}")
    public ResponseEntity<?> listBookByUser(@PathVariable Long user_id){
        return ResponseEntity.ok(borrowedService.listBookByUser(user_id));
    }

    @GetMapping("/time")
    public ResponseEntity<?> ListBookByTime(@RequestBody TimeBookBorrowed date){
        return ResponseEntity.ok(borrowedService.listBookByTime(date.getStart(), date.getEnd())) ;
    }

    @GetMapping("/most-book")
    public ResponseEntity<?> theMostBookByTime(@RequestBody TimeBookBorrowed date){
        return ResponseEntity.ok(borrowedService.findTheMostBook(date.getStart(), date.getEnd()));
    }
}
