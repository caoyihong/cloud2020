package cn.springcloud.consumer.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import out.SpringContextUtils;

@RestController
public class ConsumerController {
    @GetMapping("/hello")
    public String hello() {
//        Object obj = ApplicationContextUtil.getBean("helloController");
        Object obj = SpringContextUtils.getBean("consumerController");
//        WebApplicationContext context = ContextLoader.getCurrentWebApplicationContext();
//        Object obj = context.getBean("helloController");
        System.out.println(obj);
//        WebApplicationContextUtils.getWebApplicationContext();
        return "hello,world";
    }
}
