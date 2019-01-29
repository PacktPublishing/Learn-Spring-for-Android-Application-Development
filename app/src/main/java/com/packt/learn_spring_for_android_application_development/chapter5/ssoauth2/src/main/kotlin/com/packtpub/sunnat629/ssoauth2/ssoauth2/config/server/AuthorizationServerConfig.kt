package com.packtpub.sunnat629.ssoauth2.ssoauth2.config.server

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Configuration
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer


@Configuration
@EnableAuthorizationServer
class AuthorizationServerConfig: AuthorizationServerConfigurerAdapter() {

   @Autowired
   lateinit var authenticationManager: AuthenticationManager

    @Autowired
    lateinit var passwordEncoder: BCryptPasswordEncoder

    @Throws(Exception::class)
    override fun configure(security: AuthorizationServerSecurityConfigurer?) {
        security!!.checkTokenAccess("isAuthenticated()")
    }

    @Throws(Exception::class)
    override fun configure(clients: ClientDetailsServiceConfigurer?) {
       clients!!
               .inMemory()
               .withClient("client")
               .secret(passwordEncoder.encode("secret"))
               .authorizedGrantTypes("password", "client_credentials")
               .authorities("ROLE_CLIENT", "ROLE_TRUSTED_CLIENT")
               .scopes("read", "write", "trust")
               .resourceIds("oauth2-resource")
               .accessTokenValiditySeconds(5000) // token validity time duration 5 minuets

    }

    @Throws(Exception::class)
    override fun configure(endpoints: AuthorizationServerEndpointsConfigurer?) {
        endpoints!!.authenticationManager(authenticationManager)
    }
}