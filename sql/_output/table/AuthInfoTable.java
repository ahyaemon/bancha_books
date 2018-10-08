package com.volundes.bancha.infra.entity.table;

import org.seasar.doma.*;

@Entity(immutable = true)
@Table(name = "auth_info")
public class AuthInfoTable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    final public Long id;

    @Column(name = "account_id")
    final public Integer accountId;

    @Column(name = "email")
    final public String email;

    @Column(name = "password")
    final public String password;

    @Column(name = "role")
    final public String role;

    public BookInfoTable(Long id, Integer accountId, String email, String password, String role) {
        this.id = id
        this.accountId = accountId
        this.email = email
        this.password = password
        this.role = role
    }

}
