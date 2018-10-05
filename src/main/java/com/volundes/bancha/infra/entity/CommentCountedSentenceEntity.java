package com.volundes.bancha.infra.entity;

import org.seasar.doma.*;

@Entity
public class CommentCountedSentenceEntity {

    @Column(name = "sentence_id")
    public Long sentenceId;

    @Column(name = "comment_count")
    public Long commentCount;

}
