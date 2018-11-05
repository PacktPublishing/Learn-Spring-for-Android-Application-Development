package importAnnotation

import org.springframework.context.annotation.AnnotationConfigApplicationContext

fun main(args: Array<String>) {
    val applicationContext = AnnotationConfigApplicationContext(ConfigBoo::class.java)


    val foo: Foo = applicationContext.getBean(Foo::class.java)
//    val boo: Boo = applicationContext.getBean(Boo::class.java)

}