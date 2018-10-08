package com.volundes.bancha.infra.entity.table;

import org.seasar.doma.*;

@Entity(immutable = true)
@Table(name = "comment")
public class CommentTable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    final public Long id;

    @Column(name = "sentence_id")
    final public Integer sentenceId;

    @Column(name = "account_id")
    final public Integer accountId;

    @Column(name = "value")
    final public String value;

    public BookInfoTable(Long id, Integer sentenceId, Integer accountId, String value) {
        this.id = id
        this.sentenceId = sentenceId
        this.accountId = accountId
        this.value = value
    }

}
