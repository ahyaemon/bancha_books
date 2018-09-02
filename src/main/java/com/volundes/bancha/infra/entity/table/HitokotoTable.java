package com.volundes.bancha.infra.entity.table;

import org.seasar.doma.*;

@Entity
@Table(name = "hitokoto")
public class HitokotoTable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "hitokoto_id")
    public Long hitokotoId;

    @Column(name = "account_id")
    public Long accountId;

    @Column(name = "value")
    public String value;

}
