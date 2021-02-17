package org.example.spring2.aop;

public class Tester implements ITester{
    private boolean busyAsTester;
    public boolean isBusyAsTester() {
        return busyAsTester;
    }

    public void setBusyAsTester(boolean busyAsTester) {
        this.busyAsTester = busyAsTester;
    }

    public void testSoftware() {
        System.out.println("I will ensure the quality.");
    }
}
