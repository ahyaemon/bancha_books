package com.volundes.bancha.env.init.flyway

import com.volundes.bancha.infra.dao.*
import com.volundes.bancha.infra.entity.*
import com.volundes.bancha.infra.entity.table.AuthorTable
import com.volundes.bancha.infra.entity.table.CommentTable
import com.volundes.bancha.infra.entity.table.DonationTable
import org.springframework.stereotype.Component

@Component
class RestoreTargetMapHolder{
    private val targets = mapOf(
            Pair(AuthorDao::class.java, AuthorTable::class.java),
            Pair(BookDao::class.java, InsertBookEntity::class.java),
            Pair(SentenceDao::class.java, SentenceEntity::class.java),
            Pair(CommentDao::class.java, CommentTable::class.java),
            Pair(DonationDao::class.java, DonationTable::class.java)
    )

    fun getTargets() = targets
}