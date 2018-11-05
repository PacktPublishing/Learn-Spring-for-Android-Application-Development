package lifecycleCallback

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration


@Configuration
open class ConfigFoo {
    @Bean(initMethod = "init", destroyMethod = "destroy")
    open fun foo(): Foo {
        return Foo()
    }
}