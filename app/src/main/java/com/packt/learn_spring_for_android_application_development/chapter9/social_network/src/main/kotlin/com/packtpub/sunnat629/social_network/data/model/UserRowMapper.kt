package com.packtpub.sunnat629.social_network.data.model

import org.springframework.jdbc.core.RowMapper
import java.sql.ResultSet
import java.sql.SQLException

class UserRowMapper : RowMapper<User> {

    @Throws(SQLException::class)
    override fun mapRow(row: ResultSet, rowNumber: Int): User? {
        return User(row.getLong("id"),
                row.getString("username"),
                row.getString("password"))
    }
}