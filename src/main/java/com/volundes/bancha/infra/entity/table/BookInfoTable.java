package com.volundes.bancha.infra.entity.table;

import org.seasar.doma.*;

@Entity(immutable = true)
@Table(name = "book_info")
public class BookInfoTable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    final public Long id;

    @Column(name = "title")
    final public String title;

    @Column(name = "author_id")
    final public Integer authorId;

    public BookInfoTable(Long id, String title, Integer authorId) {
        this.id = id;
        this.title = title;
        this.authorId = authorId;
    }

}
