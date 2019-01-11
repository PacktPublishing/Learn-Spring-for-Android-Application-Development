package com.packtpub.sunnat629.ssoauth2.ssoauth2.config.server

import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter

@Configuration
@EnableResourceServer
class ResourceServerConfig: ResourceServerConfigurerAdapter(){

    @Throws(Exception::class)
    override fun configure(http: HttpSecurity?) {
        http!!
                .authorizeRequests()
                .antMatchers("/open_for_all").permitAll() // anyone can enter
                .antMatchers("/private").authenticated() // only authorized user can enter
    }
}