package com.volundes.bancha.infra.entity.table;

import org.seasar.doma.*;

@Entity
@Table(name = "license")
public class LicenseTable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public Long id;

    @Column(name = "book_id")
    public Long bookId;

    @Column(name = "notice")
    public String notice;

    @Column(name = "license_type")
    public String licenseType;
}
