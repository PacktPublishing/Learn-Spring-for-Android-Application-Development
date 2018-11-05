package importAnnotation

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Import
import org.springframework.stereotype.Controller

@Configuration
open class ConfigFoo {
    @Bean
    open fun foo(): Foo{
        return Foo()
    }
}

@Configuration
@Import(ConfigFoo::class)
open class ConfigBoo {
    @Bean
    open fun foo(): Boo {
        return Boo()
    }
}