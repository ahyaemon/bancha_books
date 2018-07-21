package com.volundes.bancha


import org.springframework.security.authentication.BadCredentialsException
import org.springframework.security.core.AuthenticationException
import org.springframework.security.web.authentication.AuthenticationFailureHandler
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

class FailureHandler: AuthenticationFailureHandler {
    override fun onAuthenticationFailure(
            httpServletRequest: HttpServletRequest,
            httpServletResponse: HttpServletResponse,
            authenticationException: AuthenticationException) {

        var errorId = ""
        // ExceptionからエラーIDをセットする
        if (authenticationException is BadCredentialsException) {
            errorId = "ERR-0001"
        }

        // ログイン画面にリダイレクト
        httpServletResponse.sendRedirect(httpServletRequest.contextPath + "/index?error=" + errorId)
    }
}