package com.volundes.bancha.domain.service.admin

import org.springframework.context.ApplicationContext
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

/**
 * 管理用の処理を担うServiceです。
 */
@Service
@Transactional
class AdminService(
        private val applicationContext: ApplicationContext
)