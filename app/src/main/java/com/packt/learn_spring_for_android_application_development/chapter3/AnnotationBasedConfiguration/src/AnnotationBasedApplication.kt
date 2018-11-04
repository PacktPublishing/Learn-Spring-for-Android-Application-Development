package ktPackage

import org.springframework.context.support.ClassPathXmlApplicationContext


fun main(args: Array<String>) {
    val context = ClassPathXmlApplicationContext("beans.xml")
    val users = context.getBean("users") as Users

    println("Name: "+users.getName())
    println("Village: "+users.getVillage())

}
