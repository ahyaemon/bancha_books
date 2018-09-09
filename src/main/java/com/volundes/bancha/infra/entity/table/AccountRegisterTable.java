package com.volundes.bancha.infra.entity.table;

import org.seasar.doma.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "account_register")
public class AccountRegisterTable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "account_register_id")
    public Long accountRegisterId;

    @Column(name = "mail_address")
    public String mailAddress;

    @Column(name = "url_key")
    public String urlKey;

    @Column(name = "create_date_time")
    public LocalDateTime createDateTime;

}
