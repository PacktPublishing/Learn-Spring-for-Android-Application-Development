package ktPackage

import org.springframework.context.support.ClassPathXmlApplicationContext


fun main(args: Array<String>) {
    val context = ClassPathXmlApplicationContext("beans.xml")
    val objectA = context.getBean("userGreeting", UserGreeting::class.java)
    objectA.getUserSurname()
    objectA.setGreeting("Naruto Uzumaki")
    objectA.getGreeting()
    context.registerShutdownHook()
}
