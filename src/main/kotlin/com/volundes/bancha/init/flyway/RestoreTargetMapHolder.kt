package com.volundes.bancha.init.flyway

import com.volundes.bancha.infra.dao.CommentDao
import com.volundes.bancha.infra.dao.DonationDao
import com.volundes.bancha.infra.entity.CommentEntity
import com.volundes.bancha.infra.entity.DonationEntity
import org.springframework.stereotype.Component

@Component
class RestoreTargetMapHolder{
    private val targets = mapOf(
            Pair(CommentDao::class.java, CommentEntity::class.java),
            Pair(DonationDao::class.java, DonationEntity::class.java)
    )

    fun getTargets() = targets
}