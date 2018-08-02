package com.volundes.bancha.infra.entity;

import org.seasar.doma.Column;
import org.seasar.doma.Entity;

@Entity
public class SentenceSummaryEntity {

    @Column(name = "sentence_id")
    public Long sentenceId;

    @Column(name = "sentence")
    public String sentence;

    @Column(name = "comment_id")
    public Long commentId;

    @Column(name = "comment_name")
    public String commentName;

    @Column(name = "comment")
    public String comment;

}
