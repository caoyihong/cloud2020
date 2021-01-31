package org.example.spring2.news;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

public class NewsApplication {
    public static void main(String[] args) {
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        BeanFactory container = bindViaXMLFile(beanFactory);
//        FXNewsProvider newsProvider = (FXNewsProvider) container.getBean("djNewsProvider");
//        newsProvider.getAndPersistNews();
        MockNewsPersister persister = (MockNewsPersister) container.getBean("mockPersister");
        persister.persistNews();
        persister.persistNews();
    }

    public static BeanFactory bindViaXMLFile(BeanDefinitionRegistry registry) {
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(registry);
        reader.loadBeanDefinitions("classpath:/news-spring.xml");
//        return new XmlBeanFactory(new ClassPathResource("news-spring.xml"));
        return (BeanFactory) registry;
    }
}
