package com.volundes.bancha.infra.entity.table;

import org.seasar.doma.*;

@Entity
@Table(name = "book")
public class BookTable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public Long id;

    @Column(name = "book_info_id")
    public Long bookInfoId;

}
