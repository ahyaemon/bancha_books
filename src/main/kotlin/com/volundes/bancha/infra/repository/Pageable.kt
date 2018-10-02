package com.volundes.bancha.infra.repository

import com.volundes.bancha.domain.`object`.paging.Page
import org.seasar.doma.jdbc.SelectOptions

interface Pageable{

    fun Page.toSelectOptions(): SelectOptions{
        return SelectOptions.get()
                .offset(offset())
                .limit((limit()))
    }

}