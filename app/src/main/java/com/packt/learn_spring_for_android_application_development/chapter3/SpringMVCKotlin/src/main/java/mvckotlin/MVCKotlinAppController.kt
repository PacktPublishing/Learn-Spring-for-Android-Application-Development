package mvckotlin

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.servlet.ModelAndView

@Controller
class MVCKotlinAppController {
    @RequestMapping("/SpringMVCKotlin")
    fun greetingMessage(): ModelAndView {
        val message =
                "<h3>Welcome to Learn Spring for Android Application Development</h3>"
        return ModelAndView("welcome", "message", message)
    }
}