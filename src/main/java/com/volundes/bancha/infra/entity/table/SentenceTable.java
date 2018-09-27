package com.volundes.bancha.infra.entity.table;

import org.seasar.doma.*;

@Entity
@Table(name = "sentence")
public class SentenceTable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sentence_id")
    public Long sentenceId;

    @Column(name = "book_id")
    public Long bookId;

    @Column(name = "sentence")
    public String sentence;

    @Column(name = "heading")
    public Integer heading;

}
