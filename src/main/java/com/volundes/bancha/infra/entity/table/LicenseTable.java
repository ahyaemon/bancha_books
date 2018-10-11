package com.volundes.bancha.infra.entity.table;

import org.seasar.doma.*;

@Entity(immutable = true)
@Table(name = "license")
public class LicenseTable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    final public Long id;

    @Column(name = "book_info_id")
    final public Integer bookInfoId;

    @Column(name = "notice")
    final public String notice;

    @Column(name = "license_type")
    final public String licenseType;

    public LicenseTable(Long id, Integer bookInfoId, String notice, String licenseType) {
        this.id = id;
        this.bookInfoId = bookInfoId;
        this.notice = notice;
        this.licenseType = licenseType;
    }

}
