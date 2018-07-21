package com.volundes.bancha.infra.entity;

import org.seasar.doma.*;

@Entity
@Table(name = "comment")
public class AccountEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "account_id")
    public Long accountId;

    @Column(name = "name")
    public String name;

    @Column(name = "pass")
    public String pass;

    @Column(name = "role")
    public String role;

}
