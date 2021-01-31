package org.example.spring2.news;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 注解扫描启动类
 */
public class NewsComponentScanApplication {
    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:/news-spring.xml");
        FXNewsProvider newsProvider = (FXNewsProvider) ctx.getBean("djNewsProvider");
        newsProvider.getAndPersistNews();
    }
}
