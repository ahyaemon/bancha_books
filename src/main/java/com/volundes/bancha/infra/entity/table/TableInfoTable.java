package com.volundes.bancha.infra.entity.table;

import org.seasar.doma.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "table_infor")
public class TableInfoTable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "table_info_id")
    public Long tableInfoId;

    @Column(name = "name")
    public String name;

    @Column(name = "version")
    public String version;

}
