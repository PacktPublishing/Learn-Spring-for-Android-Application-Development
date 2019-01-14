package com.packtpub.sunnat629.social_network

import com.packtpub.sunnat629.social_network.repository.ProfileRepository
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mockito
import org.mockito.Mockito.verify
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.http.MediaType
import org.springframework.test.context.junit4.SpringRunner
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.MvcResult
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import java.util.*

@RunWith(SpringRunner::class)
//@SpringBootTest
@WebMvcTest
class SocialNetworkApplicationTests {

	@Autowired
	private lateinit var mockMvc: MockMvc

	@MockBean
	private lateinit var profileRepository: ProfileRepository

	@Test
	fun contextLoads() {

		Mockito.`when`(profileRepository.findAll()).thenReturn(Collections.emptyList())


	 	val mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/profiles")
				.accept(MediaType.APPLICATION_JSON))
				.andReturn()

		println(mvcResult.response)

		verify(profileRepository).findAll()

	}

}

