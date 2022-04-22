package com.elcom.library.entity.lib.model;

import com.elcom.library.entity.lib.Author;
import com.elcom.library.entity.lib.Book;
import com.elcom.library.entity.lib.Category;
import com.elcom.library.entity.lib.Letter;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;
import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document(indexName = "book")
public class BookModel implements Serializable {
    @Id
    @Field(type = FieldType.Keyword)
    private String id;

    @Field(type = FieldType.Text)
    private String name;

    @Field(type = FieldType.Text)
    private String time;
//    private Author author;
//    private Category category;
//    private Letter letter;

    public BookModel(Book book) {
        this.id = String.valueOf(book.getId());
        this.name = book.getName();
        this.time = book.getTime();
//        this.author = book.getAuthor();
//        this.category = book.getCategory();
//        this.letter = book.getLetter();
    }
}
