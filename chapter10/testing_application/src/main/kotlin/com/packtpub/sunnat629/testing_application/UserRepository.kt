package com.packtpub.sunnat629.testing_application

import org.springframework.data.jpa.repository.JpaRepository

interface UserRepository: JpaRepository<Users, Int>