package configurationBeanAnnotations

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration


@Configuration
open class GreetingConfigurationConfBean{
  @Bean
  open fun greeting(): GreetingConfBean{
      return GreetingConfBean()
  }
}