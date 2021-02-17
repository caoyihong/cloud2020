package org.example.spring2.aop;

import org.springframework.aop.support.DelegatingIntroductionInterceptor;

public class IntroductionMain {
    public static void main(String[] args) {
        ITester delegate = new Tester();
        DelegatingIntroductionInterceptor interceptor = new DelegatingIntroductionInterceptor(delegate);
        // 进行织入
//        ITester tester = weaver
    }
}
