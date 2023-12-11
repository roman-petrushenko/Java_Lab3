package org.fpm.di.example;

import javax.inject.Inject;






public class UseA {
    @Inject
    private A dependency = null;

    //@Inject
    //public UseA(){
    //}
    /*@Inject
    public UseA(A a) {
        this.dependency = a;
    }*/

    public A getDependency() {
        return dependency;
    }
}
