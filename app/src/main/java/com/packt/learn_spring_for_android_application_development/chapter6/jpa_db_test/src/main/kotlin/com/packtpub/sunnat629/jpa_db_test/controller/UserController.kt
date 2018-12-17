package com.packtpub.sunnat629.jpa_db_test.jpa_db_test.controller

import com.packtpub.sunnat629.jpa_db_test.jpa_db_test.model.UserModel
import com.packtpub.sunnat629.jpa_db_test.jpa_db_test.service.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import javax.validation.Valid


@RestController
@RequestMapping("/jpa_db_test")
class UserController {

    @Autowired
    private lateinit var userService: UserService

    // to get all the users details
    @GetMapping("/users")
    fun getAllUsers(): List<UserModel>{
        return userService.findAll()
    }

    // to get one specific user details
    @GetMapping("/users/{id}")
    fun getUser(@PathVariable(name = "id") id: Long): UserModel {
        return userService.findById(id).get()
    }

    // to add a user
    @PostMapping("/users")
    fun addUser(@Valid @RequestBody userModel: UserModel): UserModel{
        println(userModel.toString())
        return userService.save(userModel)
    }

    // to update a user
    @PutMapping("/users/{id}")
    fun updateUser(@PathVariable(name = "id")id: Long, @Valid @RequestBody userDetails: UserModel): UserModel{
        val currentUser: UserModel = userService.findById(id).get()

        currentUser.name = userDetails.name
        currentUser.email = userDetails.email
        currentUser.contact_number = userDetails.contact_number

        return userService.save(currentUser)
    }

    // to delete a user
    @DeleteMapping("/users/{id}")
    fun deleteUser(@PathVariable(name = "id")id: Long): ResponseEntity<*>{
        println(userService.findById(id).get())
        userService.delete(userService.findById(id).get())

        return ResponseEntity.ok().build<Any>()
    }
}