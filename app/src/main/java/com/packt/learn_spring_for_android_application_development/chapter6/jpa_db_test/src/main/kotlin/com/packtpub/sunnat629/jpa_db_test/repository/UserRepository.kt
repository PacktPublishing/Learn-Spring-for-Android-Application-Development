package com.packtpub.sunnat629.jpa_db_test.dao

import com.packtpub.sunnat629.jpa_db_test.model.UserModel
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface UserDAO: JpaRepository<UserModel, Long>