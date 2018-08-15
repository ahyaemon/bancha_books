package com.volundes.bancha.infra.entity.table;

import org.seasar.doma.*;

@Entity
@Table(name = "subtitle")
public class SubtitleTable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "subtitle_id")
    public Long subtitleId;

    @Column(name = "title_cd")
    public String titleCd;

    @Column(name = "subtitle")
    public String subtitle;
}
