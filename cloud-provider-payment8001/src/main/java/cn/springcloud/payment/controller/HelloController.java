package cn.springcloud.payment.controller;

import org.springframework.beans.factory.BeanFactoryUtils;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;
import org.springframework.web.context.support.WebApplicationContextUtils;
import out.ApplicationContextUtil;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import out.SpringContextUtils;

@RestController
public class HelloController {

    @GetMapping("/hello")
    public String hello() {
//        Object obj = ApplicationContextUtil.getBean("helloController");
        Object obj = SpringContextUtils.getBean("helloController");
//        WebApplicationContext context = ContextLoader.getCurrentWebApplicationContext();
//        Object obj = context.getBean("helloController");
        System.out.println(obj);
//        WebApplicationContextUtils.getWebApplicationContext();
        return "hello,world";
    }
}
