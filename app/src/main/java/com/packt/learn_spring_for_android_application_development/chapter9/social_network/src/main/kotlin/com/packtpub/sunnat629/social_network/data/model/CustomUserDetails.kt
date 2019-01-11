package com.packtpub.sunnat629.social_network.data.model

import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.authority.SimpleGrantedAuthority
import netscape.security.Privilege
import org.springframework.security.core.authority.AuthorityUtils
import java.util.ArrayList




class CustomUserDetails(user: User) : UserDetails {

    private var mUser: User = user

    override fun getAuthorities(): MutableCollection<out GrantedAuthority> {
        return AuthorityUtils.createAuthorityList("USER")
    }

    override fun isEnabled(): Boolean {
        return true
    }

    override fun getUsername(): String {
        return mUser.username
    }

    override fun isCredentialsNonExpired(): Boolean {
        return true
    }

    override fun getPassword(): String {
        return mUser.password
    }

    override fun isAccountNonExpired(): Boolean {
        return true
    }

    override fun isAccountNonLocked(): Boolean {
        return true
    }
}