package com.volundes.bancha.infra.entity;

import org.seasar.doma.*;

@Entity
@Table(name = "menu")
public class MenuEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "menu_id")
    public Long menuId;

    @Column(name = "title")
    public String title;

    @Column(name = "subtitle")
    public String subtitle;

    @Column(name = "url")
    public String url;

}
