package com.packtpub.sunnat629.social_network.repository

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.stereotype.Repository

@Repository
class UserExistRepository: UserExistInterface {
    @Autowired
    private lateinit var jdbcTemplate: JdbcTemplate

    override fun isUserExist(name: String): Boolean {
        val sql = "SELECT count(*) FROM USER WHERE username = ?"
        val count = jdbcTemplate.queryForObject(sql, Int::class.java, name)
        return count != 0
    }

}

interface UserExistInterface{
    fun isUserExist(name: String): Boolean
}
