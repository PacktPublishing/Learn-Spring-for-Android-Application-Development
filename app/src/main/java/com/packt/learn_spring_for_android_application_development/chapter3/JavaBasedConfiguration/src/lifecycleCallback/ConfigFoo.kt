package importAnnotation

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Import
import org.springframework.stereotype.Controller

@Controller
class ConfigFoo {
    @Bean
    fun foo(): Foo{
        return Foo()
    }
}

@Controller
@Import(ConfigFoo::class)
class ConfigBoo {
    @Bean
    fun foo(): Boo {
        return Boo()
    }
}