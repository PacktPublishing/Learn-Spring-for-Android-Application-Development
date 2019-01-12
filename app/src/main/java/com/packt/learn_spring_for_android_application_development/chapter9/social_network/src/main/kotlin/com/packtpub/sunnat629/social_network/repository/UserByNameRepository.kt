package com.packtpub.sunnat629.social_network.repository

import com.packtpub.sunnat629.social_network.data.model.User
import com.packtpub.sunnat629.social_network.data.model.UserRowMapper
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Repository

@Repository
class UserByNameRepository: UserByNameRepositoryInterface {
    @Autowired
    private lateinit var jdbcTemplate: JdbcTemplate

    override fun getUserByName(username: String): User {
        val sql = "SELECT * FROM USER WHERE username = ?"
        val user = jdbcTemplate.queryForObject(sql, UserRowMapper(), username)

        return user!!
    }

    override fun getUserByNamePassword(username: String, password: String): Boolean {
        println("*********** $username : $password")

        val sql = "SELECT * FROM USER WHERE username = ?, password = ?"
        val user = jdbcTemplate.queryForObject(sql, UserRowMapper(), username, password)

        println("*********** ${user?.username}")

        return user != null
    }

}

interface UserByNameRepositoryInterface{
        fun getUserByName(username: String): User
        fun getUserByNamePassword(username: String, password: String): Boolean
}

