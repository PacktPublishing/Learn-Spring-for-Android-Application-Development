package com.packtpub.sunnat629.social_network

import com.packtpub.sunnat629.social_network.model.Profile
import com.packtpub.sunnat629.social_network.repository.ProfileRepository
import org.assertj.core.api.Assertions.assertThat
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager
import org.springframework.test.context.junit4.SpringRunner

@RunWith(SpringRunner::class)
@DataJpaTest
class ProfileRepositoryTest {

    @Autowired
    private lateinit var entityManager: TestEntityManager

    @Autowired
    private lateinit var profileRepository: ProfileRepository

    @Test
    fun getUserTesting(){
        val newProfile = getNewProfile()
        val saveProfile = entityManager.merge(newProfile)

        val foundProfile = profileRepository.getOne(saveProfile.id!!)

        assertThat(foundProfile.username)
                .isEqualTo(saveProfile.username)
    }

    private fun getNewProfile(): Profile {
        return Profile( "naruto",
                "12345",
                "naruto123@gmail.com",
                "Naruto",
                "Uzumak")
    }

  }