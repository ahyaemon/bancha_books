package com.volundes.bancha.infra.entity;

import org.seasar.doma.*;

@Entity
@Table(name = "donation")
public class DonationEntity {

    @Column(name="name")
    public String name;

    @Column(name="comment")
    public String comment;

    @Column(name = "amount")
    public Long amount;

}
