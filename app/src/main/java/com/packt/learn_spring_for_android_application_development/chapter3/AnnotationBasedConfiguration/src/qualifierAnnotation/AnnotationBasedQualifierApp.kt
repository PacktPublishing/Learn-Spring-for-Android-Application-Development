package requiredAnnotation

import org.springframework.context.support.ClassPathXmlApplicationContext
import qualifierAnnotation.Fighters


fun main(args: Array<String>) {
    val context = ClassPathXmlApplicationContext("qualifierAnnotation/beans_for_qualifier.xml")

    val fighters = context.getBean("fighters") as Fighters
    fighters.getName()
    fighters.getVillage()
}
