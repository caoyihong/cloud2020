package org.example.spring2.factory;

public class NonStaticBarInterfaceFactory {
    public BarInterface getInstance() {
        return new BarInterfaceImpl();
    }
}
