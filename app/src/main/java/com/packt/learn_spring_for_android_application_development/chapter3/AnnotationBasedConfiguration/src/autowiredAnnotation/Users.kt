package autowiredAnnotation

import org.springframework.beans.factory.annotation.Autowired

class User(val name: String,
            val id: String)


class Users{
    private var user:User ?= null

    @Autowired
    fun setUser(user: User){
        this.user = user
    }
}