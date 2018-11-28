package com.packtpub.sunnat629.jdbc_test.jdbc_test.model

import org.springframework.jdbc.core.RowMapper
import java.sql.ResultSet
import java.sql.SQLException

class StudentRowMapper : RowMapper<StudentModel>{

    @Throws(SQLException::class)
    override fun mapRow(row: ResultSet, rowNumber: Int): StudentModel? {
        return StudentModel(row.getInt("id"),
                row.getString("name"),
                row.getString("email"),
                row.getString("contact_number"))
    }
}