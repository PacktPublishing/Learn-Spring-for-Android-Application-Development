package com.packtpub.sunnat629.social_network.repository

import com.packtpub.sunnat629.social_network.model.Comment
import com.packtpub.sunnat629.social_network.model.LikeObj
import com.packtpub.sunnat629.social_network.model.Post
import com.packtpub.sunnat629.social_network.model.Profile
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.NoRepositoryBean
import org.springframework.data.repository.query.Param
import org.springframework.data.repository.query.QueryByExampleExecutor
import org.springframework.stereotype.Repository
import org.springframework.stereotype.Service

@Repository
interface ProfileRepository : JpaRepository<Profile, Long>, QueryByExampleExecutor<Profile>

@Repository
interface PostRepository : JpaRepository<Post, Long>

@Repository
interface CommentRepository : JpaRepository<Comment, Long>

@Repository
interface LikeRepository : JpaRepository<LikeObj, Long>

