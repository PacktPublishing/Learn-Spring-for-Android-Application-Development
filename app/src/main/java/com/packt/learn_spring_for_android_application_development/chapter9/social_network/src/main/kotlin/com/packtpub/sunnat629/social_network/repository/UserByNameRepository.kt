package com.packtpub.sunnat629.social_network.repository

import com.packtpub.sunnat629.social_network.model.Profile
import com.packtpub.sunnat629.social_network.model.UserRowMapper
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.stereotype.Repository

@Repository
class UserByNameRepository: UserByNameInterface {
    @Autowired
    private lateinit var jdbcTemplate: JdbcTemplate

    override fun getUserByName(username: String): Profile {
        val sql = "SELECT * FROM PROFILE WHERE username = ?"
        val profile = jdbcTemplate.queryForObject(sql, UserRowMapper(), username)


        return profile!!
    }

    override fun getUserByNamePassword(username: String, password: String): Boolean {
        println("*********** $username : $password")

        val sql = "SELECT * FROM PROFILE WHERE username = ?, password = ?"
        val profile = jdbcTemplate.queryForObject(sql, UserRowMapper(), username, password)

        println("*********** ${profile?.username}")

        return profile != null
    }
}


interface UserByNameInterface {
    fun getUserByName(username: String): Profile
    fun getUserByNamePassword(username: String, password: String): Boolean
}


