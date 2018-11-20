package com.packtpub.sunnat629.ssbasicauth.controller


import com.packtpub.sunnat629.ssbasicauth.model.Users
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import java.util.*

@Controller
class UserController {

    @RequestMapping(path = ["/user"], method = [RequestMethod.GET])
    fun userList(): ResponseEntity<List<Users>>{
        return ResponseEntity(getUsers(), HttpStatus.OK)
    }

    private fun getUsers(): List<Users> {
        val user = Users("1","Sunnat", "sunnat123@gmail.com", "0123456789")
        val user1 = Users("2","Chaity", "chaity123@gmail.com", "1234567890")
        val user2 = Users("3","Jisan", "jisan123@gmail.com", "9876543210")
        val user3 = Users("4","Mirza", "mirza123@gmail.com", "5412309876")
        val user4 = Users("5","Hasib", "hasib123@gmail.com", "5678901234")

        return Arrays.asList<Users>(user, user1, user2, user3, user4)
    }

}