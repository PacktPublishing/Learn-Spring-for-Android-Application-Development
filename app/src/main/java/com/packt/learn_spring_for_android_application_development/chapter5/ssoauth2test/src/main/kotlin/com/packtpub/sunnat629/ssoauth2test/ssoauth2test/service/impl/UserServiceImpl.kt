package com.packtpub.sunnat629.ssoauth2test.ssoauth2test.service.impl


import com.packtpub.sunnat629.ssoauth2test.ssoauth2test.dao.UserDao
import com.packtpub.sunnat629.ssoauth2test.ssoauth2test.model.User
import com.packtpub.sunnat629.ssoauth2test.ssoauth2test.service.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.stereotype.Service
import java.util.*

@Service(value = "userService")
class UserServiceImpl : UserDetailsService, UserService {

    @Autowired
    private val userDao: UserDao? = null

    private val authority: List<SimpleGrantedAuthority>
        get() = Arrays.asList(SimpleGrantedAuthority("ROLE_ADMIN"))

    @Throws(UsernameNotFoundException::class)
    override fun loadUserByUsername(userId: String): UserDetails {
        val user = userDao!!.findByUserName(userId)
        return org.springframework.security.core.userdetails.User(user.username!!, user.password!!, authority)
    }

    override fun findAll(): List<User> {
        val list = ArrayList<User>()
        userDao!!.findAll().iterator().forEachRemaining { list.add(it) }
        return list
    }

    override fun findOne(id: Long): User {
        return userDao!!.findById(id).get()
    }

    override fun delete(id: Long) {
        userDao!!.deleteById(id)
    }

    override fun save(user: User): User {
        return userDao!!.save(user)
    }
}
