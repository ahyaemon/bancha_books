package com.volundes.bancha.infra.entity.table;

import org.seasar.doma.*;

@Entity(immutable = true)
@Table(name = "table_info")
public class TableInfoTable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    final public Long id;

    @Column(name = "name")
    final public String name;

    @Column(name = "version")
    final public String version;

    public TableInfoTable(Long id, String name, String version) {
        this.id = id;
        this.name = name;
        this.version = version;
    }

}
