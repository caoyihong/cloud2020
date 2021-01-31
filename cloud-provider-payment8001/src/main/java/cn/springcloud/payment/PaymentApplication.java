package cn.springcloud.payment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;
import out.ApplicationContextUtil;

@SpringBootApplication
//@ComponentScan(basePackages = {"out"})
public class PaymentApplication {
    public static void main(String[] args) {
        SpringApplication.run(PaymentApplication.class, args);
//        SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(ApplicationContextUtil.class);
    }
}
