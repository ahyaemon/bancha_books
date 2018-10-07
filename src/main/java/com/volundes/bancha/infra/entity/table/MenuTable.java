package com.volundes.bancha.infra.entity.table;

import org.seasar.doma.*;

@Entity
@Table(name = "menu")
public class MenuTable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public Long id;

    @Column(name = "title")
    public String title;

    @Column(name = "subtitle")
    public String subtitle;

    @Column(name = "url")
    public String url;

}
