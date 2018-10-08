package com.volundes.bancha.infra.entity.table;

import org.seasar.doma.*;

@Entity(immutable = true)
@Table(name = "sentence")
public class SentenceTable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    final public Long id;

    @Column(name = "book_id")
    final public Integer bookId;

    @Column(name = "value")
    final public String value;

    @Column(name = "heading")
    final public Integer heading;

    public SentenceTable(Long id, Integer bookId, String value, Integer heading) {
        this.id = id;
        this.bookId = bookId;
        this.value = value;
        this.heading = heading;
    }

}
