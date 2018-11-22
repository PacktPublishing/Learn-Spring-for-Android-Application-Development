package com.packtpub.sunnat629.ssoauth2test.ssoauth2test.config

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.web.servlet.FilterRegistrationBean
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer
import org.springframework.security.oauth2.provider.token.TokenStore
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore
import org.springframework.web.cors.CorsConfiguration
import org.springframework.web.cors.UrlBasedCorsConfigurationSource
import org.springframework.web.filter.CorsFilter

@Configuration
@EnableAuthorizationServer
class AuthorizationServerConfig : AuthorizationServerConfigurerAdapter() {

    @Autowired
    private val authenticationManager: AuthenticationManager? = null

    @Bean
    fun accessTokenConverter(): JwtAccessTokenConverter {
        val converter = JwtAccessTokenConverter()
        converter.setSigningKey("as466gf")
        return converter
    }

    @Bean
    fun tokenStore(): TokenStore {
        return JwtTokenStore(accessTokenConverter())
    }

    @Throws(Exception::class)
    override fun configure(configurer: ClientDetailsServiceConfigurer?) {

        configurer!!
                .inMemory()
                .withClient(CLIEN_ID)
                .secret(CLIENT_SECRET)
                .authorizedGrantTypes(GRANT_TYPE_PASSWORD, AUTHORIZATION_CODE, REFRESH_TOKEN, IMPLICIT)
                .scopes(SCOPE_READ, SCOPE_WRITE, TRUST)
                .accessTokenValiditySeconds(ACCESS_TOKEN_VALIDITY_SECONDS).refreshTokenValiditySeconds(FREFRESH_TOKEN_VALIDITY_SECONDS)
    }

    override fun configure(endpoints: AuthorizationServerEndpointsConfigurer?) {
        endpoints!!.tokenStore(tokenStore())
                .authenticationManager(authenticationManager)
                .accessTokenConverter(accessTokenConverter())
    }

    companion object {

        internal val CLIEN_ID = "devglan-client"
        //static final String CLIENT_SECRET = "devglan-secret";
        internal val CLIENT_SECRET = "$2a$04\$e/c1/RfsWuThaWFCrcCuJeoyvwCV0URN/6Pn9ZFlrtIWaU/vj/BfG"
        internal val GRANT_TYPE_PASSWORD = "password"
        internal val AUTHORIZATION_CODE = "authorization_code"
        internal val REFRESH_TOKEN = "refresh_token"
        internal val IMPLICIT = "implicit"
        internal val SCOPE_READ = "read"
        internal val SCOPE_WRITE = "write"
        internal val TRUST = "trust"
        internal val ACCESS_TOKEN_VALIDITY_SECONDS = 1 * 60 * 60
        internal val FREFRESH_TOKEN_VALIDITY_SECONDS = 6 * 60 * 60
    }

}