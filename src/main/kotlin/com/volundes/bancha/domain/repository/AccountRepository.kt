package com.volundes.bancha.domain.repository

import com.volundes.bancha.domain.dto.*
import com.volundes.bancha.infra.dao.AccountDao
import com.volundes.bancha.infra.dao.BookDao
import com.volundes.bancha.infra.dao.CommentDao
import com.volundes.bancha.infra.dao.SentenceDao
import com.volundes.bancha.infra.mapper.AccountInfraMapper
import com.volundes.bancha.infra.mapper.BookInfraMapper
import com.volundes.bancha.infra.mapper.CommentInfraMapper
import com.volundes.bancha.infra.mapper.SentenceInfraMapper
import org.springframework.stereotype.Repository

@Repository
class AccountRepository(
        private val accountDao: AccountDao,
        private val accountInfraMapper: AccountInfraMapper
        ) {

    fun getByUsername(name: String): Account{
        return accountInfraMapper.toAccount(accountDao.selectByName(name))
    }

}