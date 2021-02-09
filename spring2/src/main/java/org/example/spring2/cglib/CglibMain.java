package org.example.spring2.cglib;

import net.sf.cglib.proxy.Enhancer;

public class CglibMain {
    public static void main(String[] args) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(Requestable.class);
        enhancer.setCallback(new RequestCtrlCallback());

        Requestable proxy = (Requestable) enhancer.create();
        proxy.request();
    }
}
