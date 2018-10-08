package com.volundes.bancha.infra.entity.table;

import org.seasar.doma.*;

@Entity(immutable = true)
@Table(name = "donation")
public class DonationTable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    final public Long id;

    @Column(name = "name")
    final public String name;

    @Column(name = "comment")
    final public String comment;

    @Column(name = "amount")
    final public Long amount;

    public BookInfoTable(Long id, String name, String comment, Long amount) {
        this.id = id
        this.name = name
        this.comment = comment
        this.amount = amount
    }

}
