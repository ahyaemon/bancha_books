package com.volundes.bancha.infra.entity.table;

import org.seasar.doma.*;

@Entity(immutable = true)
@Table(name = "hitokoto")
public class HitokotoTable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    final public Long id;

    @Column(name = "account_id")
    final public Integer accountId;

    @Column(name = "value")
    final public String value;

    public BookInfoTable(Long id, Integer accountId, String value) {
        this.id = id
        this.accountId = accountId
        this.value = value
    }

}
