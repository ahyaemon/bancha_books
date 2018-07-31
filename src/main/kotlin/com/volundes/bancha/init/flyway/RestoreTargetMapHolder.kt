package com.volundes.bancha.init.flyway

import com.volundes.bancha.infra.dao.*
import com.volundes.bancha.infra.entity.*
import org.springframework.stereotype.Component

@Component
class RestoreTargetMapHolder{
    private val targets = mapOf(
            Pair(AuthorDao::class.java, AuthorEntity::class.java),
            Pair(BookDao::class.java, InsertBookEntity::class.java),
            Pair(SentenceDao::class.java, SentenceEntity::class.java),
            Pair(CommentDao::class.java, CommentEntity::class.java),
            Pair(DonationDao::class.java, DonationEntity::class.java)
    )

    fun getTargets() = targets
}