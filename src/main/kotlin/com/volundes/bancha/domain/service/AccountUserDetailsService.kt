package com.volundes.bancha.domain.service

import com.volundes.bancha.domain.dto.AccountUserDetails
import com.volundes.bancha.domain.repository.AccountRepository
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