package com.packtpub.sunnat629.ssbasicauth.config

import org.springframework.security.core.AuthenticationException
import javax.servlet.http.HttpServletResponse
import javax.servlet.ServletException
import java.io.IOException
import javax.servlet.http.HttpServletRequest
import org.springframework.security.web.authentication.www.BasicAuthenticationEntryPoint
import org.springframework.stereotype.Component


@Component
class AuthenticationEntryPoint : BasicAuthenticationEntryPoint() {

    @Throws(IOException::class, ServletException::class)
    override fun commence(request: HttpServletRequest,
                          response: HttpServletResponse,
                          authEx: AuthenticationException) {
        response.addHeader("WWW-Authenticate", "Basic realm=$realmName")
        response.status = HttpServletResponse.SC_UNAUTHORIZED
        val message = response.writer
        message.println("HTTP Status 401 - " + authEx.message)
    }

    @Throws(Exception::class)
    override fun afterPropertiesSet() {
        realmName = "packtpub"
        super.afterPropertiesSet()
    }
}