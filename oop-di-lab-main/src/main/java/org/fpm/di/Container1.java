package org.fpm.di;

public class Container1 implements Container{
    Binder1 binder111;
    public Container1(Binder1 binder11){
        binder111 = binder11;

    }
    public <T> T getComponent(Class<T> clazz) {
        return binder111.getComponent(clazz);
    }
}
