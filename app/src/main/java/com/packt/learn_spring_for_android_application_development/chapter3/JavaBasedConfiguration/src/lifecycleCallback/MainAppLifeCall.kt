package lifecycleCallback

import org.springframework.context.annotation.AnnotationConfigApplicationContext

fun main(args: Array<String>) {
    val applicationContext = AnnotationConfigApplicationContext(ConfigFoo::class.java)

    val foo: Foo = applicationContext.getBean(Foo::class.java)
    applicationContext.registerShutdownHook()
}