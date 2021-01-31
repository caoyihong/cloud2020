package org.example.spring2.event2;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;

import java.util.ArrayList;
import java.util.List;

public class MethodExeuctionEventPublisher implements ApplicationEventPublisherAware {
    private ApplicationEventPublisher eventPublisher;

    private List<MethodExecutionEventListener> listeners = new ArrayList<MethodExecutionEventListener>();

    public void methodToMonitor() {
        MethodExecutionEvent beginEvt = new MethodExecutionEvent(this, "methodToMonitor",MethodExecutionStatus.BEGIN);
        this.eventPublisher.publishEvent(beginEvt);
        // ...
        MethodExecutionEvent endEvt = new MethodExecutionEvent(this, "methodToMonitor",MethodExecutionStatus.END);
        this.eventPublisher.publishEvent(endEvt);

    }

    public static void main(String[] args) {
//        MethodExeuctionEventPublisher eventPublisher = new MethodExeuctionEventPublisher();
//        eventPublisher.addMethodExecutionEventListener(new SimpleMethodExecutionEventListener());
//        eventPublisher.methodToMonitor();
    }

    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        this.eventPublisher = applicationEventPublisher;
    }
}
