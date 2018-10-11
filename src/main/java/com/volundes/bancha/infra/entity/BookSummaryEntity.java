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

    @Column(name = "author_id")
    public Long authorId;

    @Column(name = "author_name")
    public String authorName;

    @Column(name = "license_id")
    public Long licenseId;

    @Column(name = "notice")
    public String notice;

    @Column(name = "license_type")
    public String licenseType;

    @Column(name = "sentence_id")
    public Long sentenceId;

    @Column(name = "sentence")
    public String sentence;

    @Column(name = "heading")
    public Integer heading;

    @Column(name = "comment_count")
    public Long commentCount;

}
