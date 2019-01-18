package com.packtpub.sunnat629.jdbc_test.controller

import com.packtpub.sunnat629.jdbc_test.UserModel
import com.packtpub.sunnat629.jdbc_test.service.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
class UserController {
    @Autowired
    private lateinit var userService: UserService

    //    Getting the User List
    @GetMapping(path = ["/users"])
    fun getAllUsers(): ResponseEntity<List<UserModel>> {
        return ResponseEntity(userService.getAllUserList(),
                HttpStatus.OK)
    }

    //    Getting one User by ID
    @GetMapping(path = ["/user/{id}"])
    fun getAllUserByID(@PathVariable("id") id: Int): ResponseEntity<UserModel> {
        return ResponseEntity(userService.getUserByID(id),
                HttpStatus.OK)
    }

    //    Inserting new User
    @PostMapping(path = ["/user/new"])
    fun addNewUser(@RequestBody userModel: UserModel): String {
        ResponseEntity(userService.addNewUser(userModel), HttpStatus.CREATED)
        return "${userModel.name} has been added to database"
    }

    //    Updating a User
    @PutMapping(path = ["/user/{id}"])
    fun updateUser(@RequestBody userModel: UserModel, @PathVariable("id") id: Int): ResponseEntity<UserModel> {
        System.out.println("$id = $userModel")
        userService.updateUser(userModel, id)
        return ResponseEntity(userModel, HttpStatus.OK)
    }

    //    Deleting a User
    @DeleteMapping(path = ["/user/{id}"])
    fun deleteUser(@PathVariable("id") id: Int): String {
        userService.deleteUser(id)
        return "$id User has been deleted."
    }
}