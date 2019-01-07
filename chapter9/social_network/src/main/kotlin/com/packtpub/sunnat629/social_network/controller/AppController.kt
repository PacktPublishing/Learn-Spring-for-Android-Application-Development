package com.packtpub.sunnat629.social_network.controller

import com.packtpub.sunnat629.social_network.data.model.Profile
import com.packtpub.sunnat629.social_network.data.model.RegisteredUser
import com.packtpub.sunnat629.social_network.repository.ProfileRepository
import com.packtpub.sunnat629.social_network.repository.RegRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RestController
import java.time.Instant

@RestController
class AppController {

    @Autowired
    lateinit var regRepository: RegRepository

    @Autowired
    lateinit var profileRepository: ProfileRepository

    @PostMapping("/save")
    fun getTest(): MutableIterable<Profile> {
        regRepository.save(RegisteredUser("sunnat629","suncha629@gmail.com", "password",
                "admin", Instant.now()))

        profileRepository.save(Profile("Mohi-Us", "Sunnat"))
        return profileRepository.findAll()
    }


}