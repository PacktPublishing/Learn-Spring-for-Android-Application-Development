package com.packtpub.sunnat629.jdbc_test.jdbc_test.controller

import com.packtpub.sunnat629.jdbc_test.jdbc_test.model.UserModel
import com.packtpub.sunnat629.jdbc_test.jdbc_test.service.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping(path = ["/jdbc_db_test"])
class UserController {

    @Autowired
    val userService: UserService?= null

    @GetMapping
    fun getTest(): String{
        return "I am Sunnat..."
    }

    @GetMapping(path = ["/users"])
    fun getAllUserNames(): ResponseEntity<List<UserModel>> {
        return ResponseEntity(userService!!.getAllUserList(),
                HttpStatus.OK)
    }
}