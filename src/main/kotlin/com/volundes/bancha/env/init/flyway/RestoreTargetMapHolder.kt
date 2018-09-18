package com.volundes.bancha.env.init.flyway

import com.volundes.bancha.infra.dao.*
import com.volundes.bancha.infra.entity.table.*
import org.springframework.stereotype.Component

@Component
class RestoreTargetMapHolder{
    private val targets = mapOf(
            Pair(AuthorDao::class.java, AuthorTable::class.java),
            Pair(BookDao::class.java, BookTable::class.java),
            Pair(SentenceDao::class.java, SentenceTable::class.java),
            Pair(CommentDao::class.java, CommentTable::class.java),
            Pair(DonationDao::class.java, DonationTable::class.java)
    )

    fun getTargets() = targets
}