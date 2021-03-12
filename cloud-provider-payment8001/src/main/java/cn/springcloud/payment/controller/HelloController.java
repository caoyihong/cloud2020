package cn.springcloud.payment.controller;

import cn.springcloud.payment.mcb.Cookbook;
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

import java.sql.Connection;
import java.sql.SQLException;

@RestController
public class HelloController {

    @GetMapping("/hello")
    public String hello() {
        Connection conn = null;
        try {
            conn = Cookbook.connect();
            System.out.println("connected...");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                    System.out.println("disconnected...");
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }
        return "hello,world";
    }
}
