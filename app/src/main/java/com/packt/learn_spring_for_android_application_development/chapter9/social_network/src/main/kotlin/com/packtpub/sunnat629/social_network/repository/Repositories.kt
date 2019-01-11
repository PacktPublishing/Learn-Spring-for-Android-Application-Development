package com.packtpub.sunnat629.social_network.repository

import com.packtpub.sunnat629.social_network.data.model.Comment
import com.packtpub.sunnat629.social_network.data.model.LikeObj
import com.packtpub.sunnat629.social_network.data.model.Post
import com.packtpub.sunnat629.social_network.data.model.User
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface UserRepository : CrudRepository<User, Long>

@Repository
interface PostRepository : CrudRepository<Post, Long>

@Repository
interface CommentRepository : CrudRepository<Comment, Long>

@Repository
interface LikeRepository : CrudRepository<LikeObj, Long>
