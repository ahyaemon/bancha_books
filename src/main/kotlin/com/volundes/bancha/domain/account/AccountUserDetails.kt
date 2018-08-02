package com.volundes.bancha.domain.account

import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.userdetails.User

class AccountUserDetails(
        private val account: Account,
        private val enabled: Boolean,
        private val accountNonExpired: Boolean,
        private val credentialsNonExpired: Boolean,
        private val accountNonLocked: Boolean,
        private val authorities: List<GrantedAuthority>
): User(
        account.name,
        account.pass,
        enabled,
        accountNonExpired,
        credentialsNonExpired,
        accountNonLocked,
        authorities
) {

    fun getAccount(): Account {
        return account
    }
}