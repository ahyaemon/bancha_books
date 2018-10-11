package com.volundes.bancha.infra.entity.table;

import org.seasar.doma.*;

import java.time.LocalDateTime;

@Entity(immutable = true)
@Table(name = "account_register")
public class AccountRegisterTable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    final public Long id;

    @Column(name = "email")
    final public String email;

    @Column(name = "url_key")
    final public String urlKey;

    @Column(name = "create_date_time")
    final public LocalDateTime createDateTime;

    public AccountRegisterTable(Long id, String email, String urlKey, LocalDateTime createDateTime) {
        this.id = id;
        this.email = email;
        this.urlKey = urlKey;
        this.createDateTime = createDateTime;
    }

}
