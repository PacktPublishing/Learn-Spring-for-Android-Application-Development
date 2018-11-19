package com.packtpub.sunnat629.springsecurity

import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.beans.factory.annotation.Autowired
import javax.sql.DataSource


class ApplicationSecurity: WebSecurityConfigurerAdapter() {
    @Autowired
    fun initialize(builder: AuthenticationManagerBuilder, dataSource: DataSource){
        builder.jdbcAuthentication().dataSource(dataSource).withUser("Sunnat629")
                .password("packtPub").roles("USER")
    }
}