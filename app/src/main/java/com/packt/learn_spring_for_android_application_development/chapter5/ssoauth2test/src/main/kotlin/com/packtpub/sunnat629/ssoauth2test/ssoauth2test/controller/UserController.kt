package com.packtpub.sunnat629.ssoauth2test.ssoauth2test.controller


import com.packtpub.sunnat629.ssoauth2test.ssoauth2test.model.User
import com.packtpub.sunnat629.ssoauth2test.ssoauth2test.service.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/users")
class UserController {

    @Autowired
    private val userService: UserService? = null

    @RequestMapping(value = ["/user"], method = [RequestMethod.GET])
    fun listUser(): List<User> {
        return userService!!.findAll()
    }

    @RequestMapping(value = ["/user"], method = [RequestMethod.POST])
    fun create(@RequestBody user: User): User {
        return userService!!.save(user)
    }

    @RequestMapping(value = ["/user/{id}"], method = [RequestMethod.GET])
    fun findOne(@PathVariable id: Long): User {
        return userService!!.findOne(id)
    }

    @RequestMapping(value = ["/user/{id}"], method = [RequestMethod.PUT])
    fun update(@PathVariable id: Long, @RequestBody user: User): User {
        user.id = id
        return userService!!.save(user)
    }

    @RequestMapping(value = ["/user/{id}"], method = [RequestMethod.DELETE])
    fun delete(@PathVariable(value = "id") id: Long?) {
        userService!!.delete(id!!)
    }
}
