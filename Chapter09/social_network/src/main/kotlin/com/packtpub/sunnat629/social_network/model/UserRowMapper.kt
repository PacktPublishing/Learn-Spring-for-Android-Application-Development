package com.packtpub.sunnat629.social_network.model

import org.springframework.jdbc.core.RowMapper
import java.sql.ResultSet
import java.sql.SQLException

class UserRowMapper : RowMapper<Profile> {

    @Throws(SQLException::class)
    override fun mapRow(row: ResultSet, rowNumber: Int): Profile? {
        val profile = Profile(row.getLong("id"),
                row.getString("username"),
                row.getString("password"))

        println(profile.toString())
        return profile
    }
}