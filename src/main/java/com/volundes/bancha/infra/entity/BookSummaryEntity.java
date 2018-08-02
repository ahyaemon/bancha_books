package com.volundes.bancha.infra.entity;

import org.seasar.doma.Column;
import org.seasar.doma.Entity;
import org.seasar.doma.Table;

@Entity
public class BookSummaryEntity {

    @Column(name = "book_id")
    public Long bookId;

    @Column(name = "name")
    public String name;

    @Column(name = "author")
    public String author;

    @Column(name = "sentence_id")
    public Long sentenceId;

    @Column(name = "sentence")
    public String sentence;

    @Column(name = "comment_id")
    public Long commentId;

    @Column(name = "comment_name")
    public String commentName;

    @Column(name = "comment")
    public String comment;

}
