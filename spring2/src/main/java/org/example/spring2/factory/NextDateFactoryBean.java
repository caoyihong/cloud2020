package org.example.spring2.factory;

import org.springframework.beans.factory.FactoryBean;

import java.util.Date;

public class NextDateFactoryBean implements FactoryBean {
    public Object getObject() throws Exception {
        return new Date();
    }

    public Class getObjectType() {
        return Date.class;
    }

    public boolean isSingleton() {
        return false;
    }
}
