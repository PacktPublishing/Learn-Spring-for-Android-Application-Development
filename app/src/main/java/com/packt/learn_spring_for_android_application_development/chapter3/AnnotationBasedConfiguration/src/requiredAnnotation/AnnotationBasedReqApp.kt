package requiredAnnotation

import org.springframework.context.support.ClassPathXmlApplicationContext


fun main(args: Array<String>) {
    val context = ClassPathXmlApplicationContext("requiredAnnotation/beans_for_req.xml")
    val users = context.getBean("users") as UsersForReq

    println("Name: "+users.getName())
    println("Village: "+users.getVillage())
}
