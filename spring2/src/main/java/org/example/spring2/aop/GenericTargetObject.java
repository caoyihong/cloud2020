package org.example.spring2.aop;

import org.example.spring2.annotation.ClassLevelAnnotation;
import org.example.spring2.annotation.MethodLevelAnnotation;

@ClassLevelAnnotation
public class GenericTargetObject {
    @MethodLevelAnnotation
    public void gMethod1() {
        System.out.println("gMethod1");
    }

    public void gMethod2() {
        System.out.println("gMethod2");
    }
}
