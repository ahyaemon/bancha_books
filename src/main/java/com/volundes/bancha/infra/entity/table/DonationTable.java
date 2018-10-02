package com.volundes.bancha.infra.entity.table;

import org.seasar.doma.*;

@Entity
@Table(name = "donation")
public class DonationTable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    public Long id;

    @Column(name="name")
    public String name;

    @Column(name="comment")
    public String comment;

    @Column(name = "amount")
    public Long amount;

}
