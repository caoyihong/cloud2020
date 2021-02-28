package org.example.spring2.weaver;

public class MockTask implements ITask{
    public void execute(TaskExecutionContext ctx) {
        System.out.println("task executed.");
    }
}
