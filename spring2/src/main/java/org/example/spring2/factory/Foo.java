package org.example.spring2.factory;

public class Foo {
    private BarInterface barInterface;

    public BarInterface getBarInterface() {
        return barInterface;
    }

    public void setBarInterface(BarInterface barInterface) {
        this.barInterface = barInterface;
    }
    //    public Foo() {
//        barInterface = BarInterfaceFactory.getInstance();
//        barInterface = new BarInterfaceFactory().getInstance();
//    }
}
