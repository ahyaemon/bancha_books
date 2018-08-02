package com.volundes.bancha.domain.account

import com.volundes.bancha.infra.repository.AccountRepository
import org.springframework.security.core.authority.AuthorityUtils
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.stereotype.Service

@Service
class AccountUserDetailsService(
        private val accountRepository: AccountRepository
): UserDetailsService {
    override fun loadUserByUsername(username: String): UserDetails{
        val account = accountRepository.getByUsername(username)
        val grantedAuthorities = AuthorityUtils.createAuthorityList("ROLE_ADMIN")
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