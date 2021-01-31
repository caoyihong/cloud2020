package org.example.spring2.main;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.StaticMessageSource;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;

import java.util.Locale;

public class ResourceApplication {
    public static void main(String[] args) {
        StaticMessageSource messageSource = new StaticMessageSource();
        messageSource.addMessage("menu.file", Locale.US, "File");
        messageSource.addMessage("menu.edit", Locale.US, "Edit");
        String msg = messageSource.getMessage("menu.edit", null, Locale.US);
        System.out.println(msg);

//
//        ResourceLoader resourceLoader = new ClassPathXmlApplicationContext("classpath:/news-spring.xml");
//        Resource fileResource = resourceLoader.getResource("component-scan.xml");
//        if (fileResource instanceof ClassPathResource) {
//            System.out.println("classpath 资源加载。。。");
//        }
//        if (fileResource.exists()) {
//            System.out.println("资源存在。。。");
//        }
    }
}
