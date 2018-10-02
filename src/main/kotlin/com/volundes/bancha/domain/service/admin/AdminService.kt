package com.volundes.bancha.domain.service.admin

import org.springframework.context.ApplicationContext
import org.springframework.stereotype.Service

/**
 * 管理用の処理を担うServiceです。
 */
@Service
class AdminService(
        private val applicationContext: ApplicationContext
)