package com.packtpub.sunnat629.jdbc_test.jdbc_test.repository

import com.packtpub.sunnat629.jdbc_test.jdbc_test.model.UserModel
import com.packtpub.sunnat629.jdbc_test.jdbc_test.model.UserRowMapper
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.stereotype.Repository

@Repository
class UserRepository: UserRepositoryInterface {
    @Autowired
    private var jdbcTemplate: JdbcTemplate? = null

    override fun getAllUserDetails(): List<UserModel> {
        val selectAllSql = "SELECT * FROM users;"
        return jdbcTemplate!!.query(selectAllSql, UserRowMapper())
    }
}