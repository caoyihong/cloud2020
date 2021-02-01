package org.example.spring2.proxy;

public class SubjectImpl implements Isubject {
    public String request() {
        System.out.println("SubjectImpl.request()方法执行");
        return "request...";
    }
}
