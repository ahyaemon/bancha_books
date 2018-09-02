package com.volundes.bancha.infra.entity;

import org.seasar.doma.*;

@Entity
public class ProfileEntity {

    @Column(name = "account_id")
    public Long accountId;

    @Column(name = "name")
    public String name;

    @Column(name = "pass")
    public String pass;

    @Column(name = "role")
    public String role;

    @Column(name = "nickname")
    public String nickname;

    @Column(name = "hitokoto_id")
    public Long hitokotoId;

    @Column(name = "hitokoto_value")
    public String hitokotoValue;

}
