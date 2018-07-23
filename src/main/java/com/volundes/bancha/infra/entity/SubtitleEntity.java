package com.volundes.bancha.infra.entity;

import org.seasar.doma.*;

@Entity
@Table(name = "subtitle")
public class SubtitleEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "subtitle_id")
    public Long subtitleId;

    @Column(name = "title_cd")
    public String titleCd;

    @Column(name = "subtitle")
    public String subtitle;
}
