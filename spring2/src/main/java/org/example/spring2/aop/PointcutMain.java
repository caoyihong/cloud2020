package org.example.spring2.aop;

import org.example.spring2.annotation.ClassLevelAnnotation;
import org.example.spring2.annotation.MethodLevelAnnotation;
import org.springframework.aop.Pointcut;
import org.springframework.aop.support.annotation.AnnotationMatchingPointcut;

public class PointcutMain {
    public static void main(String[] args) {
//        Pointcut
//        AnnotationMatchingPointcut pointcut = new AnnotationMatchingPointcut(ClassLevelAnnotation.class);
        AnnotationMatchingPointcut classPointcut = AnnotationMatchingPointcut.forClassAnnotation(ClassLevelAnnotation.class);
        AnnotationMatchingPointcut methodPointcut = AnnotationMatchingPointcut.forClassAnnotation(MethodLevelAnnotation.class);

        AnnotationMatchingPointcut unionPointcut = new AnnotationMatchingPointcut(ClassLevelAnnotation.class, MethodLevelAnnotation.class);

    }
}
