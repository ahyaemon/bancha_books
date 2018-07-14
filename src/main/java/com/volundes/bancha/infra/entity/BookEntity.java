package com.volundes.bancha.infra.entity;

import org.seasar.doma.*;

@Entity
@Table(name = "book")
public class BookEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "book_id")
    public Long bookId;

    @Column(name = "name")
    public String name;

    @Column(name = "author")
    public String author;

    @Column(name = "isbn")
    public String isbn;
}
