package com.volundes.bancha.web.menu

import com.volundes.bancha.domain.menu.Menu

class MenuItem(
        var menuId: Long?,
        var title: String,
        var subtitle: String,
        var url: String
) {
    constructor(menu: Menu): this(menu.menuId, menu.title, menu.subtitle, menu.url)
}