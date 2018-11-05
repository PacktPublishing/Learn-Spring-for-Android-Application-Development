package dependenciesInjectBean

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
open class GreetingConfigurationDIBean{
    @Bean
    open fun greeting(): GreetingDIBean {
        return GreetingDIBean(getUserDetails())
    }

    @Bean
    open fun getUserDetails(): GreetingDetailsDIBean {
        return GreetingDetailsDIBean()
    }
}