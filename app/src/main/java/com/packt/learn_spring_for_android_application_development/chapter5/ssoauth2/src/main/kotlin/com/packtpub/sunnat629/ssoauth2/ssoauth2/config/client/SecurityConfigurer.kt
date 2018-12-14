package com.packtpub.sunnat629.ssoauth2.ssoauth2.config.client

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.config.BeanIds
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder

@Configuration
@EnableWebSecurity
class SecurityConfigurer: WebSecurityConfigurerAdapter() {

    @Throws(Exception::class)
    override fun configure(auth: AuthenticationManagerBuilder?) {
        auth!!
                .inMemoryAuthentication()
                .passwordEncoder(passwordEncoder())
             // user1 as USER
                .withUser("user")
                .password(passwordEncoder().encode("password"))
                .roles("USER")
                .and()

                // user2 as ADMIN
                .withUser("admin")
                .password("password")
                .roles("ADMIN")
    }

    @Throws(Exception::class)
    override fun configure(http: HttpSecurity?) {
        http!!
                .antMatcher("/**")
                .authorizeRequests()
                .antMatchers("/","/login**")
                .permitAll()
                .anyRequest()
                .authenticated()
    }

    @Bean(name = [BeanIds.AUTHENTICATION_MANAGER])
    @Throws(Exception::class)
    override fun authenticationManagerBean(): AuthenticationManager {
        return super.authenticationManagerBean()
    }


    @Bean
    fun passwordEncoder(): BCryptPasswordEncoder {
        return BCryptPasswordEncoder(16)
    }
}