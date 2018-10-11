package com.volundes.bancha.infra.entity;

import org.seasar.doma.*;

@Entity
public class BookEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "book_id")
    public Long bookId;

    @Column(name = "book_info_id")
    public Long bookInfoId;

    @Column(name = "book_title")
    public String title;

    @Column(name = "author_id")
    public Long authorId;

    @Column(name = "author_name")
    public String authorName;

    @Column(name = "license_id")
    public Long licenseId;

    @Column(name = "license_notice")
    public String licenseNotice;

    @Column(name = "license_type")
    public String licenseType;

    @Column(name = "sentence_id")
    public Long sentenceId;

    @Column(name = "sentence_value")
    public String sentenceValue;

    @Column(name = "sentence_heading")
    public String sentenceHeading;

    @Column(name = "comment_id")
    public Long commentId;

    @Column(name = "comment_account_id")
    public Long commentAccountId;

    @Column(name = "comment_value")
    public String commentValue;

    @Column(name = "comment_name")
    public String commentName;


}
