package ktPackage


class UserGreeting/*(surname: UserSurname)*/ {
//    private var userSurname: UserSurname ?= surname

    private var userSurname: UserSurname? = null

    fun setUserSurnameClass(surname: UserSurname) {
        println("Setting User Surname in UserGreeting")
        userSurname = surname
    }

    fun getUserSurnameClass(): UserSurname? {
        return userSurname
    }

    /*init {
        println("It is a constructor for user's surname")
    }*/

    private var globalGreeting: String? = "Sasuke Uchiha"

    fun setGreeting(greeting: String) {
        globalGreeting = greeting
    }

    fun getGreeting() {
        println("Welcome " + globalGreeting!! + "!!")
    }

    fun afterPropertiesSet() {
        println("Bean is going to start.")
    }

    fun destroy() {
        println("Bean is going to destroy.")
    }

    fun getUserSurname() {
        userSurname?.getSurname()
    }
}