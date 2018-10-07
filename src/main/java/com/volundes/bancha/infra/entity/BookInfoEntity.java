package com.volundes.bancha.infra.entity;

import org.seasar.doma.*;

@Entity
public class BookInfoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "book_info_id")
    public Long bookInfoId;

    @Column(name = "title")
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

}
