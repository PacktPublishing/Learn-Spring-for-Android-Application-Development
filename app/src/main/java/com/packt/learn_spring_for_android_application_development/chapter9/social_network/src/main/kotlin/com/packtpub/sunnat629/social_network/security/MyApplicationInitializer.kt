//package com.packtpub.sunnat629.social_network.security
//
//import org.springframework.web.WebApplicationInitializer
//import org.springframework.web.context.support.AnnotationConfigWebApplicationContext
//import org.springframework.web.servlet.DispatcherServlet
//import javax.servlet.ServletContext
//import javax.servlet.ServletException
//
//class MyApplicationInitializer: WebApplicationInitializer {
//
//    @Throws(ServletException::class)
//    override fun onStartup(container: ServletContext) {
//
//        val rootContext = AnnotationConfigWebApplicationContext()
//        rootContext.servletContext = container
//        val servlet = container.addServlet("dispatcher", DispatcherServlet(rootContext))
//        servlet.setLoadOnStartup(1)
//        servlet.addMapping("/")
//    }
//}