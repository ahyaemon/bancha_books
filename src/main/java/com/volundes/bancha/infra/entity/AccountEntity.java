package com.volundes.bancha.infra.entity;

import org.seasar.doma.Column;
import org.seasar.doma.Entity;

@Entity
public class AccountEntity {

    @Column(name = "account_id")
    public Long accountId;

    @Column(name = "name")
    public String name;

    @Column(name = "auth_info_id")
    public Long authInfoId;

    @Column(name = "email")
    public String email;

    @Column(name = "password")
    public String password;

    @Column(name = "role")
    public String role;

    @Column(name = "hitokoto_id")
    public Long hitokotoId;

    @Column(name = "hitokoto_value")
    public String hitokotoValue;

}
