package com.volundes.bancha.web.role

import com.volundes.bancha.domain.account.Account
import org.springframework.security.core.Authentication
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ModelAttribute
import javax.servlet.http.HttpSession

@ControllerAdvice
class RoleControllerAdvice(
        private val httpSession: HttpSession
){

    @ModelAttribute("hasAdminRole")
    fun hasAdminRole(authentication: Authentication?): Boolean{
        return authentication.hasRole("ADMIN")
    }

    @ModelAttribute("hasGeneralRole")
    fun hasGeneralRole(authentication: Authentication?): Boolean{
        return authentication.hasRole("GENERAL")
    }

    @ModelAttribute("hasNoRole")
    fun hasNoRole(authentication: Authentication?): Boolean{
        return authentication == null
    }

    @ModelAttribute("account")
    fun account(): Account?{
        return httpSession.getAttribute("account") as Account?
    }

    private fun Authentication?.hasRole(role: String): Boolean {
        if(this == null){
            return false
        }
        return this.authorities.map{it.authority}.contains("ROLE_$role")
    }

}