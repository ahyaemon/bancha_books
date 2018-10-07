package com.volundes.bancha.infra.entity.table;

import org.seasar.doma.*;

@Entity
@Table(name = "comment")
public class CommentTable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public Long id;

    @Column(name = "sentence_id")
    public Long sentenceId;

    @Column(name = "account_id")
    public Long accountId;

    @Column(name = "comment")
    public String comment;

}
