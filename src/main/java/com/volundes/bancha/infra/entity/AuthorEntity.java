package com.volundes.bancha.infra.entity;

import org.seasar.doma.*;

@Entity
@Table(name = "author")
public class AuthorEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "author_id")
    public Long authorId;

    @Column(name = "name")
    public String name;

}
