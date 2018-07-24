package com.volundes.bancha.infra.entity;

import org.seasar.doma.Column;
import org.seasar.doma.Entity;
import org.seasar.doma.Table;

@Entity
@Table(name = "donation")
public class TotalAmountEntity {

    @Column(name = "total_amount")
    public Long amount;

}
