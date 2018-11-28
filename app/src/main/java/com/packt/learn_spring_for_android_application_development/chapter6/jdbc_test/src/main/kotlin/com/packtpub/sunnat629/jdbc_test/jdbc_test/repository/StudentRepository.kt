package com.packtpub.sunnat629.jdbc_test.jdbc_test.repository

import com.packtpub.sunnat629.jdbc_test.jdbc_test.model.StudentModel
import com.packtpub.sunnat629.jdbc_test.jdbc_test.model.StudentRowMapper
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.stereotype.Repository

@Repository
class StudentRepository: StudentRepositoryInterface {
    @Autowired
    private var jdbcTemplate: JdbcTemplate? = null

    override fun getAllStudentDetails(): List<StudentModel> {
        val selectAllSql = "SELECT * FROM student;"
        return jdbcTemplate!!.query(selectAllSql, StudentRowMapper())
    }
}