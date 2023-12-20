package org.fpm.di.example;

import org.fpm.di.Binder;
import org.fpm.di.Binder1;
import org.fpm.di.Configuration;

public class Configuration1 implements Configuration {
    Binder1 binder1;
    @Override
    public void configure(Binder binder) {
        binder.bind(MySingleton.class);
        binder.bind(MyPrototype.class);

        binder.bind(UseA.class);

        binder.bind(A.class, B.class);
        binder.bind(B.class, new B());
        binder1 = (Binder1)binder;
    }
}
