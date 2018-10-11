package com.volundes.bancha.infra.entity;

import org.seasar.doma.*;

@Entity
@Table(name = "book")
public class BookInfoEntityBak {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public Long id;

    @Column(name = "name")
    public String name;

    @Column(name = "author")
    public String author;

}
