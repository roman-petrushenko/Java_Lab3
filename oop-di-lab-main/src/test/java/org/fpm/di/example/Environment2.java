package org.fpm.di.example;

import org.fpm.di.Configuration;
import org.fpm.di.Container;
import org.fpm.di.Container1;
import org.fpm.di.Environment;

public class Environment2 implements Environment{

    public Container configure(Configuration configuration) {
        return new Container1(((Configuration2)configuration).binder1);
    }
}
