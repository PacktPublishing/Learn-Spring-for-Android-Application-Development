//package com.packtpub.sunnat629.social_network.repository
//
//import com.packtpub.sunnat629.social_network.data.model.User
//import com.packtpub.sunnat629.social_network.data.model.UserRowMapper
//import org.springframework.beans.factory.annotation.Autowired
//import org.springframework.jdbc.core.JdbcTemplate
//import org.springframework.stereotype.Repository
//
//@Repository
//class DeleteCommentLikeByPostID:DeleteCommentLikeByPostIDInterface {
//
//    @Autowired
//    private lateinit var jdbcTemplate: JdbcTemplate
//
//    override fun deleteCommentLikeByPostID(username: String): User {
//        val commentDeleteSql = "SELECT * FROM COMMENT WHERE username = ?"
//
//        val likeDeleteSql = "SELECT * FROM POST_LIKE WHERE username = ?"
//        println(username)
//        val user = jdbcTemplate.queryForObject(sql, UserRowMapper(), username)
//
//        println(user!!.username)
//        return user
//    }
//
//}
//
//interface DeleteCommentLikeByPostIDInterface{
//    fun deleteCommentLikeByPostID(username: String): User
//}
