package com.volundes.bancha.infra.entity.table;

import org.seasar.doma.*;

@Entity
@Table(name = "account")
public class AccountTable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "account_id")
    public Long accountId;

    @Column(name = "email")
    public String email;

    @Column(name = "pass")
    public String pass;

    @Column(name = "role")
    public String role;

    @Column(name = "nickname")
    public String nickname;

}
