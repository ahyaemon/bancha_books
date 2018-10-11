package com.volundes.bancha.domain.obj.account

import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.userdetails.User


class AccountUserDetails(
        private val authInfo: AuthInfo,
        private val enabled: Boolean,
        private val accountNonExpired: Boolean,
        private val credentialsNonExpired: Boolean,
        private val accountNonLocked: Boolean,
        private val authorities: List<GrantedAuthority>
): User(
        authInfo.email,
        authInfo.password,
        enabled,
        accountNonExpired,
        credentialsNonExpired,
        accountNonLocked,
        authorities
) {

    fun getAuthInfo(): AuthInfo {
        return authInfo
    }
}