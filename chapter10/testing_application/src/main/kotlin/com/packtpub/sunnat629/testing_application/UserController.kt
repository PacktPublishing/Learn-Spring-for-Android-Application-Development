package com.packtpub.sunnat629.testing_application


import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import java.util.*

@RestController
class UserController {

    @GetMapping(path = ["/users"])
    fun userList(): ResponseEntity<List<Users>>{
        return ResponseEntity(getUsers(), HttpStatus.OK)
    }

    private fun getUsers(): List<Users> {
        val user = Users("1","Sunnat")
        val user1 = Users("2","Chaity")
        val user2 = Users("3","Jisan")
        val user3 = Users("4","Mirza")
        val user4 = Users("5","Hasib")

        return Arrays.asList<Users>(user, user1, user2, user3, user4)
    }

}