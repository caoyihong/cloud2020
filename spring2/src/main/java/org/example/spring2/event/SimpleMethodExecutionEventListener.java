package org.example.spring2.event;

public class SimpleMethodExecutionEventListener implements MethodExecutionEventListener{
    public void onMethodBegin(MethodExecutionEvent evt) {
        String methodName = evt.getMethodName();
        System.out.println("start to execute the method["+methodName+"].");
    }

    public void onMethodEnd(MethodExecutionEvent evt) {
        String methodName = evt.getMethodName();
        System.out.println("finished to execute the method["+methodName+"].");
    }
}
