package ConfigurationBeanAnnotations

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
open class GreetingConfigurationConfBeanT{
  @Bean
  open fun greeting(): GreetingConfBean{
      return GreetingConfBean()
  }
}