package com.volundes.bancha.infra.entity.table;

import org.seasar.doma.*;

@Entity
@Table(name = "account")
public class AccountTable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public Long id;

    @Column(name = "name")
    public String name;

}
