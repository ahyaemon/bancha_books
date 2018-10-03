package com.volundes.bancha.web.role

import com.volundes.bancha.domain.obj.account.Account
import org.slf4j.LoggerFactory
import org.springframework.security.core.Authentication
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ModelAttribute
import javax.servlet.http.HttpSession

@ControllerAdvice
class RoleControllerAdvice(
        private val httpSession: HttpSession
){

    private val logger = LoggerFactory.getLogger(RoleControllerAdvice::class.java)

    @ModelAttribute("hasAdminRole")
    fun hasAdminRole(authentication: Authentication?): Boolean{
        val hasAdminRole = authentication.hasRole("ADMIN")
//        logger.info("hasAdminRole: $hasAdminRole")
        return hasAdminRole
    }

    @ModelAttribute("hasGeneralRole")
    fun hasGeneralRole(authentication: Authentication?): Boolean{
        val hasGeneralRole = authentication.hasRole("GENERAL")
//        logger.info("hasGeneralRole: $hasGeneralRole")
        return hasGeneralRole
    }

    @ModelAttribute("hasNoRole")
    fun hasNoRole(authentication: Authentication?): Boolean{
        val hasNoRole = authentication == null
//        logger.info("hasNoRole: $hasNoRole")
        return hasNoRole
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