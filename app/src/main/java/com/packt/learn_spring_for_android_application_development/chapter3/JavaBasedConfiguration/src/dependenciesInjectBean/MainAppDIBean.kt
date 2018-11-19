package dependenciesInjectBean

import org.springframework.context.annotation.AnnotationConfigApplicationContext

fun main(args: Array<String>) {
    val applicationContext = AnnotationConfigApplicationContext(GreetingConfigurationDIBean::class.java)

    val greeting = applicationContext.getBean(GreetingDIBean::class.java)
    greeting.getGreeting()
}