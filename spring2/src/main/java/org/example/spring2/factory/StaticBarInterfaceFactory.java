package org.example.spring2.factory;

public class StaticBarInterfaceFactory {
    public static BarInterface getInstance() {
        return new BarInterfaceImpl();
    }
}
