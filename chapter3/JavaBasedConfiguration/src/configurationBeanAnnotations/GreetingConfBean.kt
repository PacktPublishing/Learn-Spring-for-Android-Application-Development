package configurationBeanAnnotations

class GreetingConfBean{
    private var users: String? = null
    fun setUsers(users: String) {
        this.users = users
    }
    fun getUsers() {
        println("Welcome, $users!!")
    }
}