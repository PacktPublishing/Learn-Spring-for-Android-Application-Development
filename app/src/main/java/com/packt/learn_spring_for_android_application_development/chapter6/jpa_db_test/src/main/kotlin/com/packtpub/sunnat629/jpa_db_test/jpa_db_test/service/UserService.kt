package com.packtpub.sunnat629.jpa_db_test.jpa_db_test.service

import com.packtpub.sunnat629.jpa_db_test.jpa_db_test.model.UserModel
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface UserService: JpaRepository<UserModel, Long>