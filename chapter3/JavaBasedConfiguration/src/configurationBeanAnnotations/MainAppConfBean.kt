package configurationBeanAnnotations

import org.springframework.context.annotation.AnnotationConfigApplicationContext

fun main(args: Array<String>) {
    val applicationContext = AnnotationConfigApplicationContext(GreetingConfigurationConfBean::class.java)

    val greeting = applicationContext.getBean(GreetingConfBean::class.java)
    greeting.setUsers("Naruto Uzumaki")
    greeting.getUsers()
}