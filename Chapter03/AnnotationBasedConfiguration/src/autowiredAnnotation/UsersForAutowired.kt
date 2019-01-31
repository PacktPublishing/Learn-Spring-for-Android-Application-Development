package requiredAnnotation

import autowiredAnnotation.UserDetails
import org.springframework.beans.factory.annotation.Autowired

class UsersForAutowired @Autowired constructor(private var userDetails: UserDetails) {
    init {
        println("UsersForAutowired constructor.")
    }

    fun getUserDetails() {
        this.userDetails.getDetails()
    }
}