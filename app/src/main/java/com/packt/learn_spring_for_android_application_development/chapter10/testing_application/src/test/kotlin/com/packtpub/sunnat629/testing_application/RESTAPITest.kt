package com.packtpub.sunnat629.testing_application

import org.hamcrest.Matchers.hasSize
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.Mockito.*
import org.mockito.MockitoAnnotations
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.http.MediaType
import org.springframework.test.context.junit4.SpringRunner
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status
import org.springframework.test.web.servlet.setup.MockMvcBuilders
import java.util.*

@RunWith(SpringRunner::class)
@WebMvcTest
class RESTAPITest {

    @Autowired
    private lateinit var mockMvc: MockMvc

    @Mock
    private lateinit var userRepository: UserRepository

    @InjectMocks
    private val userController: UserController? = null

    @Before
    fun init() {
        MockitoAnnotations.initMocks(this)
        mockMvc = MockMvcBuilders
                .standaloneSetup(userController!!)
                .build()
    }

    @Test
    @Throws(Exception::class)
    fun errorTest(){
        `when`(userRepository.findById(1)).thenReturn(null)
        mockMvc.perform(get("/users/{id}", 1))
                .andExpect(status().isNotFound)

        verify(userRepository, times(1)).findAll()
        verifyNoMoreInteractions(userRepository)
    }

    @Test
    @Throws(Exception::class)
    fun addTest(){
        val userList = listOf(Users("naruto"),Users("suski") )
        `when`(userRepository.findAll()).thenReturn(userList)

        val mvcResult = mockMvc.perform(get("/users")
                .accept(MediaType.APPLICATION_JSON))
                .andReturn()

        verify(userRepository, times(1))
        verifyNoMoreInteractions(userRepository)

    }



    @Test
    fun contextLoads() {

        `when`(userRepository.findAll()).thenReturn(Collections.emptyList())


        val mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/users")
                .accept(MediaType.APPLICATION_JSON))
                .andReturn()

        println(mvcResult.response)

        Mockito.verify(userRepository).findAll()

    }

}