package com.volundes.bancha.infra.entity;

import org.seasar.doma.*;

@Entity
@Table(name = "donation")
public class DonationEntity {

    @Column(name = "amount")
    public Long amount;

}
