package com.volundes.bancha.web.controller.menu

import com.volundes.bancha.domain.dto.Book
import com.volundes.bancha.domain.dto.Menu

class MenuItem(
        var menuId: Long?,
        var title: String,
        var subtitle: String,
        var url: String
) {
    constructor(menu: Menu): this(menu.menuId, menu.title, menu.subtitle, menu.url)
}