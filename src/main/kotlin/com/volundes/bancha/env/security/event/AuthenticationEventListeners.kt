package com.volundes.bancha.env.security.event

import com.volundes.bancha.infra.repository.AccountRepository
import org.springframework.context.event.EventListener
import org.springframework.security.authentication.event.InteractiveAuthenticationSuccessEvent
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.security.core.userdetails.User
import org.springframework.stereotype.Component
import javax.servlet.http.HttpSession

@Component
class AuthenticationEventListeners(
        private val httpSession: HttpSession,
        private val accountRepository: AccountRepository
) {

    @EventListener
    fun handleInteractiveAuthenticationSuccessEvent(
            event: InteractiveAuthenticationSuccessEvent
    ) {
        val user = SecurityContextHolder.getContext().authentication.principal as User
        val account = accountRepository.findByEmail(user.username)
        httpSession.setAttribute("account", account)
    }

}