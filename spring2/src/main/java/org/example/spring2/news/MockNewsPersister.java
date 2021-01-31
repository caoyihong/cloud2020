package org.example.spring2.news;

import org.example.spring2.domain.FXNewsBean;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.ObjectFactory;

//public class MockNewsPersister implements IFXNewsPersister, BeanFactoryAware {
public class MockNewsPersister implements IFXNewsPersister {
//    private BeanFactory beanFactory;
//    private FXNewsBean newsBean;

    private ObjectFactory newsBeanFactory;

    public void persistNews(FXNewsBean bean) {
        persistNews();
    }

    public void persistNews() {
        System.out.println("persist bean:" + getNewsBean());
    }

    public FXNewsBean getNewsBean() {
//        return newsBean;
//        return (FXNewsBean) beanFactory.getBean("newsBean");
        return (FXNewsBean) newsBeanFactory.getObject();
    }

//    public void setNewsBean(FXNewsBean newsBean) {
//        this.newsBean = newsBean;
//    }

    //    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
//        this.beanFactory = beanFactory;
//    }
    public void setNewsBeanFactory(ObjectFactory newsBeanFactory) {
        this.newsBeanFactory = newsBeanFactory;
    }
}
