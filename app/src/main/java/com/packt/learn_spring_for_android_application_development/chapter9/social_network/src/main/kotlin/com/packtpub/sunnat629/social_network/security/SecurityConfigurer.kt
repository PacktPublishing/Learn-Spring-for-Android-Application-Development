package com.packtpub.sunnat629.social_network.security

import com.packtpub.sunnat629.social_network.service.CustomUserDetailsService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.crypto.factory.PasswordEncoderFactories
import org.springframework.security.crypto.password.PasswordEncoder


@Configuration
@EnableWebSecurity
class SecurityConfigurer : WebSecurityConfigurerAdapter() {

    @Autowired
    private lateinit var authEntryPoint: AuthenticationEntryPoint

    @Autowired
    private lateinit var customUserDetailsService: CustomUserDetailsService

    @Throws(Exception::class)
    override fun configure(http: HttpSecurity) {
        http.csrf().disable().authorizeRequests()
                .antMatchers("/", "/profile/new","/profiles").permitAll()
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
    fun configureGlobal(auth: AuthenticationManagerBuilder) {
        auth
                .userDetailsService(customUserDetailsService)
                .passwordEncoder(getPasswordEncoder())
    }

    @Bean
    fun getPasswordEncoder(): PasswordEncoder {
        return object : PasswordEncoder {
            override fun encode(charSequence: CharSequence): String {
                return charSequence.toString()
            }

            override fun matches(charSequence: CharSequence, s: String): Boolean {
                return true
            }
        }
    }
}