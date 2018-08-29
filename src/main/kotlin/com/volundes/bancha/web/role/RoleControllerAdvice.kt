package com.volundes.bancha.web.role

import org.springframework.security.core.Authentication
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ModelAttribute

@ControllerAdvice
class RoleControllerAdvice(){

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

    private fun Authentication?.hasRole(role: String): Boolean {
        if(this == null){
            return false
        }
        return this.authorities.map{it.authority}.contains("ROLE_$role")
    }

}