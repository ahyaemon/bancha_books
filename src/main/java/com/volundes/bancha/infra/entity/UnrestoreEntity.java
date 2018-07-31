package com.volundes.bancha.infra.entity;

import org.seasar.doma.*;

@Entity
@Table(name = "unrestore")
public class UnrestoreEntity {

    @Column(name = "table_name")
    public String tableName;

    @Column(name = "id")
    public Long id;
}
