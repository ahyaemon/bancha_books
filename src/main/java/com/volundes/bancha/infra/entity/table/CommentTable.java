package com.volundes.bancha.infra.entity.table;

import org.seasar.doma.*;

@Entity
@Table(name = "comment")
public class CommentTable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "comment_id")
    public Long commentId;

    @Column(name = "sentence_id")
    public Long sentenceId;

    @Column(name = "name")
    public String name;

    @Column(name = "comment")
    public String comment;

}