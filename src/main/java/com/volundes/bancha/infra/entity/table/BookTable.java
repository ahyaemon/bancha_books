package com.volundes.bancha.infra.entity.table;

import org.seasar.doma.*;

@Entity(immutable = true)
@Table(name = "book")
public class BookTable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    final public Long id;

    @Column(name = "book_info_id")
    final public Integer bookInfoId;

    public BookTable(Long id, Integer bookInfoId) {
        this.id = id;
        this.bookInfoId = bookInfoId;
    }

}
