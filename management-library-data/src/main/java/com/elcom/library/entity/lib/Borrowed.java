package com.elcom.library.entity.lib;


import com.elcom.library.entity.auth.User;
import com.elcom.library.entity.lib.Book;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.sql.Date;

@Getter
@Setter
@Entity
@Table(name = "borrowed")
public class Borrowed {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(name = "user_id")
    private Long user_id;

    @ManyToOne(targetEntity = com.elcom.library.entity.lib.Book.class)
    @JoinColumn(name = "book_id")
    private Book book;

    @Column(name = "date")
    private Date date;

    public Borrowed(Long user_id, Book book) {
        this.user_id = user_id;
        this.book = book;
        this.date = new Date(new java.util.Date().getTime());
    }
}
