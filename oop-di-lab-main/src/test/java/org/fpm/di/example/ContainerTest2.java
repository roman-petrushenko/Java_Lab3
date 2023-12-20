package org.fpm.di.example;

import org.fpm.di.Binder1;
import org.fpm.di.Container;
import org.fpm.di.Environment;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertSame;

public class ContainerTest2 {
    private Container container;

    @Before
    public void setUp() {
        Environment env = new Environment2();
        Configuration2 configuration11= new Configuration2();
        configuration11.configure(new Binder1());
        container = env.configure(configuration11);
    }
    @Test
    public void shouldBuildInjectionGraph() {
        /*
        binder.bind(A.class, B.class);
        binder.bind(B.class, C.class);
        binder.bind(C.class, new C());
        binder.bind(K.class);
        binder.bind(K.class, D.class);

        */
        //final C cAsSingleton = container.getComponent(C.class);
        /*C c2 = (C)container.getComponent(A.class);
        C c3 = (C)container.getComponent(B.class);
        C c4 = container.getComponent(C.class);
        System.out.println(c2);
        System.out.println(c3);
        System.out.println(c4);*/
        A a1 = container.getComponent(A.class);
        //System.out.println(a1);

        /*assertSame(container.getComponent(A.class), cAsSingleton);
        assertSame(container.getComponent(B.class), cAsSingleton);
        assertSame(container.getComponent(C.class), cAsSingleton);*/
        assertNotSame(container.getComponent(A.class), container.getComponent(A.class));

        //assertNotSame(container.getComponent(D.class), container.getComponent(K.class));*/
    }
}
