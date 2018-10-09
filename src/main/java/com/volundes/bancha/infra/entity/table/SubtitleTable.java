package com.volundes.bancha.infra.entity.table;

import org.seasar.doma.*;

@Entity(immutable = true)
@Table(name = "subtitle")
public class SubtitleTable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    final public Long id;

    @Column(name = "title_cd")
    final public String titleCd;

    @Column(name = "value")
    final public String value;

    public SubtitleTable(Long id, String titleCd, String value) {
        this.id = id;
        this.titleCd = titleCd;
        this.value = value;
    }

}
