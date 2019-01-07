package com.packtpub.sunnat629.social_network.repository

import com.packtpub.sunnat629.social_network.data.model.Profile
import com.packtpub.sunnat629.social_network.data.model.RegisteredUser
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface RegRepository: CrudRepository<RegisteredUser, Long>

@Repository
interface ProfileRepository: CrudRepository<Profile, Long>{
    fun getAll(): List<Profile>
}