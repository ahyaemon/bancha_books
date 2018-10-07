package com.volundes.bancha.infra.repository

import com.volundes.bancha.domain.obj.account.Account
import com.volundes.bancha.infra.dao.AccountDao
import com.volundes.bancha.infra.dao.AuthInfoDao
import com.volundes.bancha.infra.dao.HitokotoDao
import com.volundes.bancha.infra.mapper.AccountMapperExtension
import org.springframework.stereotype.Repository

@Repository
class AccountRepository(
        private val accountDao: AccountDao,
        private val authInfoDao: AuthInfoDao,
        private val hitokotoDao: HitokotoDao
):
        AccountMapperExtension
{

    fun findAuthInfoByEmail(email: String) =
            authInfoDao.selectByEmail(email).toAuthInfo()

    /**
     * AccountをAuthInfo, Hitokotoに分解してDBに保存します。
     */
    fun addAccount(account: Account) {
        val accountTable = account.toTable()
        accountDao.insert(accountTable)

        // authInfo, hitokoto 用に account_id を取得する
        val insertedAccountId = accountDao.selectByName(account.name).id

        val authInfoTable = account.authInfo.toTable(insertedAccountId)
        authInfoDao.insert(authInfoTable)

        if(account.hitokoto != null){
            val hitokotoTable = account.hitokoto.toTable(insertedAccountId)
            hitokotoDao.insert(hitokotoTable)
        }
    }

    fun findById(accountId: Long): Account {
        return accountDao.selectEntityById(accountId).toAccount()
    }

    fun findByEmail(email: String): Account {
        return accountDao.selectEntityByEmail(email).toAccount()
    }

    fun edit(account: Account) {
        val accountTable = account.toTable()
        accountDao.update(accountTable)

        val authInfoTable = account.authInfo.toTable(account.id!!)
        authInfoDao.update(authInfoTable)

        if(account.hitokoto != null){
            val hitokotoTable = account.hitokoto.toTable(account.id)
            hitokotoDao.update(hitokotoTable)
        }
    }

}