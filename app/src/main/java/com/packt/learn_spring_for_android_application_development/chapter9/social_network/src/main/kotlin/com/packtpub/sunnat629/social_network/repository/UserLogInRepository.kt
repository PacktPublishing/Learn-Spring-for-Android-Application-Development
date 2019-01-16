package com.packtpub.sunnat629.social_network.repository

import com.packtpub.sunnat629.social_network.model.Profile
import com.packtpub.sunnat629.social_network.model.UserRowMapper
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.stereotype.Repository

@Repository
class UserLogInRepository: UserLogInInterface {
    @Autowired
    private lateinit var jdbcTemplate: JdbcTemplate

    override fun logInCheck(username: String, password: String): Any? {

        println("**************** $username $password")
        val sqlCount = "SELECT count(*) FROM PROFILE WHERE username = ? AND password  = ?"
        val count = jdbcTemplate.queryForObject(sqlCount, Int::class.java, username, password)

        if(count != 0) {
            val sql = "SELECT * FROM PROFILE WHERE username = ? AND password  = ?"
            val profile = jdbcTemplate.queryForObject(sql, UserRowMapper(), username, password)
            return profile
        }

        return "{\"error\": \"Wrong username or password. Please Try again\"}"
    }

}

interface UserLogInInterface{
    fun logInCheck(username: String, password: String): Any?
}
