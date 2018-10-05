package com.volundes.bancha.domain.service.account

import com.volundes.bancha.domain.obj.account.AccountUserDetails
import com.volundes.bancha.infra.repository.AccountRepository
import org.springframework.security.core.authority.AuthorityUtils
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

/**
 * ユーザー認証を担うServiceです。
 * 実際の認証はSpring Securityに任せるため、このクラスを呼び出して使うことはありません。
 */
@Service
@Transactional
class AccountUserDetailsService(
        private val accountRepository: AccountRepository
): UserDetailsService {

    /**
     * 認証を行うためのUserDetailsインスタンスを返します。
     *
     * @param[username] ユーザー名
     * @return 認証を行うためのUserDetailsインスタンス
     */
    override fun loadUserByUsername(username: String): UserDetails{
        val account = accountRepository.findByEmail(username)
        val role = account.role.toUpperCase()
        val grantedAuthorities = AuthorityUtils.createAuthorityList("ROLE_$role")
        val userDetails = AccountUserDetails(
                account,
                true,
                true,
                true,
                true,
                grantedAuthorities
        )
        return userDetails
    }

}