package com.elcom.library.entity.lib;

import com.elcom.library.entity.auth.Borrowed;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Component
@Entity
@Table(name = "book")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "time")
    private String time;

    @ManyToOne
    @JoinColumn(name = "author_id")
    private Author author;

    @ManyToOne
    @JoinColumn(name = "cate_id")
    private Category category;

    @ManyToOne
    @JoinColumn(name = "letter_id")
    private Letter letter;

    @JsonIgnore
    @OneToMany(mappedBy = "book", targetEntity = Borrowed.class)
    private List<Borrowed> userBorrowed;
}
