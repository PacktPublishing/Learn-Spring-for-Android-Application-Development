package qualifierAnnotation

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Qualifier
import sun.text.normalizer.UCharacter.getAge


class Fighters {
    @Autowired
    @Qualifier("fighter2")
    lateinit var usersForQualifier: UsersForQualifier

    init {
        println("Fighters constructor.")
    }

    fun getName() {
        println("Name: " + usersForQualifier.getName())
    }

    fun getVillage() {
        println("Village: " + usersForQualifier.getVillage())
    }
}