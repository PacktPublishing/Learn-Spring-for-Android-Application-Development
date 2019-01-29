package com.packtpub.sunnat629.ssbasicauth.config

import org.apache.tomcat.util.security.MD5Encoder.encode
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.crypto.factory.PasswordEncoderFactories
import org.springframework.security.web.AuthenticationEntryPoint

@Configuration
@EnableWebSecurity
class SSConfig: WebSecurityConfigurerAdapter() {

    @Autowired
    private val authEntryPoint: AuthenticationEntryPoint? = null

    @Throws(Exception::class)
    override fun configure(http: HttpSecurity) {
        http.csrf().disable().authorizeRequests()
                .anyRequest()
                .authenticated()
                .and()
                .formLogin()
                .and()
                .httpBasic()
                .authenticationEntryPoint(authEntryPoint)
    }


    @Autowired
    @Throws(Exception::class)
    fun configureGlobal(auth: AuthenticationManagerBuilder){

        auth
                .inMemoryAuthentication()
                .withUser("sunnat629")
                .password(PasswordEncoderFactories.createDelegatingPasswordEncoder()
                        .encode("password"))
                .roles("USER")
    }
}