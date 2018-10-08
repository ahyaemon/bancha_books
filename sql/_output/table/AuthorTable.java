package com.volundes.bancha.infra.entity.table;

import org.seasar.doma.*;

@Entity(immutable = true)
@Table(name = "author")
public class AuthorTable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    final public Long id;

    @Column(name = "name")
    final public String name;

    public BookInfoTable(Long id, String name) {
        this.id = id
        this.name = name
    }

}
