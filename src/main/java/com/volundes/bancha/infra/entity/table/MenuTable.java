package com.volundes.bancha.infra.entity.table;

import org.seasar.doma.*;

@Entity(immutable = true)
@Table(name = "menu")
public class MenuTable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    final public Long id;

    @Column(name = "title")
    final public String title;

    @Column(name = "value")
    final public String subtitle;

    @Column(name = "url")
    final public String url;

    public MenuTable(Long id, String title, String subtitle, String url) {
        this.id = id;
        this.title = title;
        this.subtitle = subtitle;
        this.url = url;
    }

}
