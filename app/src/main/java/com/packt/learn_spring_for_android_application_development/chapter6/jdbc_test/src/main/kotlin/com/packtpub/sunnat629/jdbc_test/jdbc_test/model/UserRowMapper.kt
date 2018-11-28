package com.packtpub.sunnat629.jdbc_test.jdbc_test.model

import org.springframework.jdbc.core.RowMapper
import java.sql.ResultSet
import java.sql.SQLException

class UserRowMapper : RowMapper<UserModel>{

    @Throws(SQLException::class)
    override fun mapRow(row: ResultSet, rowNumber: Int): UserModel? {
        return UserModel(row.getInt("id"),
                row.getString("name"),
                row.getString("email"),
                row.getString("contact_number"))
    }
}