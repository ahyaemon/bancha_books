package com.volundes.bancha.infra.repository

import com.volundes.bancha.domain.paging.Page
import org.seasar.doma.jdbc.SelectOptions

interface Pageable{

    fun Page.toSelectOptions(): SelectOptions{
        return SelectOptions.get()
                .offset(getOffset())
                .limit((getLimit()))
    }

}