package org.example.spring2.proxy;

import java.lang.reflect.Proxy;

public class ProxyMain {
    public static void main(String[] args) {
        Isubject subject = (Isubject) Proxy.newProxyInstance(
                ProxyMain.class.getClassLoader(),
                new Class[]{Isubject.class},
                new RequestCtrlInvocationHandler(new SubjectImpl()));
        subject.request();

    }
}
