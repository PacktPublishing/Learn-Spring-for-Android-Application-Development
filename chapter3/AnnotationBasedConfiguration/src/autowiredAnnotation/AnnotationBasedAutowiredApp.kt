package requiredAnnotation

import org.springframework.context.support.ClassPathXmlApplicationContext


fun main(args: Array<String>) {
    val context = ClassPathXmlApplicationContext("autowiredAnnotation/beans_for_autowired.xml")

    val usersForAutowired = context.getBean("users") as UsersForAutowired
    usersForAutowired.getUserDetails()
}
