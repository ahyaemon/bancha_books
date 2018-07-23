package com.volundes.bancha.infra.entity;

import org.seasar.doma.*;

@Entity
@Table(name = "sentence")
public class SentenceEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sentence_id")
    public Long sentenceId;

    @Column(name = "book_id")
    public Long bookId;

    @Column(name = "sentence")
    public String sentence;
}
