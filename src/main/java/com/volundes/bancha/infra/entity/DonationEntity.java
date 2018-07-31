package com.volundes.bancha.infra.entity;

import org.seasar.doma.*;

@Entity
@Table(name = "donation")
public class DonationEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="donation_id")
    public Long donationId;

    @Column(name="name")
    public String name;

    @Column(name="comment")
    public String comment;

    @Column(name = "amount")
    public Long amount;

}
