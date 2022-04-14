package com.elcom.library.entity.lib;


import com.elcom.library.entity.auth.User;
import com.elcom.library.entity.lib.Book;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Date;

@Getter
@Setter
@Entity
@Table(name = "borrowed")
public class Borrowed {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(targetEntity = com.elcom.library.entity.lib.Book.class)
    @JoinColumn(name = "book_id")
    private Book book;

    @Column(name = "date")
    private Date date;

    public Borrowed(User user, Book book) {
        this.user = user;
        this.book = book;
        this.date = new Date(new java.util.Date().getTime());
    }
}
