package com.packtpub.sunnat629.jdbc_test.repository

import com.packtpub.sunnat629.jdbc_test.UserModel
import com.packtpub.sunnat629.jdbc_test.model.UserRowMapper
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.stereotype.Repository

@Repository
class UserRepository: UsersInterface {

    @Autowired
    private lateinit var jdbcTemplate: JdbcTemplate

    override fun getAllUserList(): List<UserModel> {
        val selectAllSql = "SELECT * FROM users"
        return jdbcTemplate.query(selectAllSql, UserRowMapper())
    }

    override fun getUserByID(id: Int): UserModel? {
        val selectAllSql = "SELECT * FROM users WHERE id = ?"
        return jdbcTemplate.queryForObject(selectAllSql, UserRowMapper(), id)
    }

    override fun addNewUser(userModel: UserModel) {
        val addQuery = "INSERT INTO users (name, email, contact_number) values (?,?,?)"
        jdbcTemplate.update(addQuery,userModel.name,userModel.email,userModel.contact_number)
    }

    override fun updateUser(userModel: UserModel, id: Int) {
        val updateQuery = "UPDATE users SET name=?,email=?, contact_number=? WHERE id=?"
        jdbcTemplate.update(updateQuery, userModel.name, userModel.email, userModel.contact_number, id)
    }

    override fun deleteUser(id: Int) {
        val deleteQuery = "DELETE FROM users WHERE id=?"
        jdbcTemplate.update(deleteQuery, id)
    }
}