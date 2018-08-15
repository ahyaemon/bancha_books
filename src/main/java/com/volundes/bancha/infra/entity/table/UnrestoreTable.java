package com.volundes.bancha.infra.entity.table;

import org.seasar.doma.*;

@Entity
@Table(name = "unrestore")
public class UnrestoreTable {

    @Column(name = "table_name")
    public String tableName;

    @Column(name = "id")
    public Long id;
}
