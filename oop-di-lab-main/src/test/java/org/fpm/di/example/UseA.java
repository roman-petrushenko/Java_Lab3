package org.fpm.di.example;

import javax.inject.Inject;






public class UseA {

    //@Inject
    private final A dependency;
    //@Inject
    private final B dependency1;

    //@Inject
    private final MyPrototype dependency2;


    //@Inject
    /*public UseA(A dependency) {
        this.dependency = dependency;
    }*/
    @Inject
    public UseA(A a, B b, MyPrototype proto) {
        this.dependency = a;
        this.dependency1 = b;
        this.dependency2 = proto;
    }


    public A getDependency() {
        return dependency;
    }
    public B getDependency1() {
        return dependency1;
    }
    public MyPrototype getDependency2() {
        return dependency2;
    }

}
