package org.example.spring2.event2;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;

import java.util.EventListener;

public class MethodExecutionEventListener implements ApplicationListener {

    public void onApplicationEvent(ApplicationEvent event) {
        if (event instanceof MethodExecutionEvent) {
            // 处理逻辑
            MethodExecutionEvent methodExecutionEvent = (MethodExecutionEvent) event;
            String methodName = methodExecutionEvent.getMethodName();
            if (MethodExecutionStatus.BEGIN.equals(methodExecutionEvent.getMethodExecutionStatus())) {
                System.out.println("start to execute the method["+methodName+"].");
            } else {
                System.out.println("finished to execute the method["+methodName+"].");
            }
        }

    }
}
