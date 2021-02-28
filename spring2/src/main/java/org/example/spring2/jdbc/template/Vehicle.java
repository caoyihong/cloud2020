package org.example.spring2.jdbc.template;

public abstract class Vehicle {
    public final void drive() {
        startTheEngine(); // 点火
        putIntoGear();  // 踩刹车，挂1挡
        looseHandBrake();   // 放手刹
        stepOnTheGasAndGo();    // 踩油门
    }
    protected abstract void putIntoGear();

    private void stepOnTheGasAndGo() {

    }

    private void looseHandBrake() {

    }

    private void startTheEngine() {

    }
}
