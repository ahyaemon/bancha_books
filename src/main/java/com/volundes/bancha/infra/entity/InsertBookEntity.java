package com.volundes.bancha.infra.entity;

import org.seasar.doma.*;

@Entity
@Table(name = "book")
public class InsertBookEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "book_id")
    public Long bookId;

    @Column(name = "name")
    public String name;

    @Column(name = "author_id")
    public Long authorId;

}
