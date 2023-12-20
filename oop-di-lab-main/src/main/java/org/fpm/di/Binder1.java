package org.fpm.di;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
//import java.util.Set;
// java.util.Set;

public class Binder1 implements Binder{
    HashMap<Class<?>,Class<?>> hashmap1 = new HashMap<>();
    HashMap<Class<?>, Object> hashmap2 = new HashMap<>();
    HashSet<Class<?>> class_set = new HashSet<>();

    public <T> void bind(Class<T> clazz) {
        class_set.add(clazz);
        //hashmap1.put(clazz, clazz);
        if (clazz.isAnnotationPresent(Singleton.class)){
            try {
                Constructor<T> constructor1 = clazz.getConstructor();
                hashmap2.put(clazz, constructor1.newInstance());

            } catch (NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException e) {
                System.out.println(e);
            }

        }

    }

    public <T> void bind(Class<T> clazz, Class<? extends T> implementation) {
        class_set.add(clazz);
        class_set.add(implementation);
        hashmap1.put(clazz, implementation);

    }

    public <T> void bind(Class<T> clazz, T instance) {
        class_set.add(clazz);
        hashmap2.put(clazz, instance);

    }
    public <T> Class<T> get_binded_class(Class<T> clazz){
        if (hashmap1.containsKey(clazz)){
            return get_binded_class((Class<T>)hashmap1.get(clazz));
        }
        return clazz;


    }

    public <T> T getComponent(Class<T> clazz){
        //System.out.println(hashmap2.containsKey(clazz));
        if (hashmap2.containsKey(clazz)){
            return (T)hashmap2.get(clazz);
        }
        Class<T> clazz1 = get_binded_class(clazz);
        //System.out.println(hashmap2.containsKey(clazz1));
        if (hashmap2.containsKey(clazz1)){
            return (T)hashmap2.get(clazz1);
        }

        try {
            //Class<T> clazz1 = get_binded_class(clazz);
            //Constructor<T> constructor3 = clazz1.getConstructor();
            //constructor3.setAccessible(true);
            //Constructor<?>[] constructor3_l = clazz1.getDeclaredConstructors();
            //if (clazz1.getDeclaredConstructors().length == 1){
                //return constructor3.newInstance();
            //}
            for (Constructor<?> i: clazz1.getConstructors()){
                if (i.isAnnotationPresent(Inject.class)){
                    ArrayList<Object> class_inst_l = new ArrayList<>();
                    i.setAccessible(true);
                    for (Class<?> j: i.getParameterTypes()){
                        class_inst_l.add(getComponent(j));
                    }
                    //i.setAccessible(true);
                    T clazz_inst = (T)i.newInstance(class_inst_l.toArray());
                    return clazz_inst;

                }}
            Constructor<T> constructor3 = clazz1.getConstructor();
            constructor3.setAccessible(true);
            return constructor3.newInstance();
            //Constructor<?>[] constructor3_l = clazz1.getDeclaredConstructors();

            }

            //Class<?>[] param_types = constructor3.getParameterTypes();
            //T clazz_inst = constructor3.newInstance();
            /*for (Class<?> i: param_types){
                //i.setAccessible(true);
                if (i.isAnnotationPresent(Inject.class)) {
                    Class<?> i_type = i.getType();

                    Constructor<?> constructor2 = i_type.getConstructor();
                    constructor2.setAccessible(true);
                    i.set(clazz_inst, constructor2.newInstance());}
                 /*for (Class<?> j: class_set){
                     if (j.equals(i_type)){
                         Constructor<?> constructor2 = j.getConstructor();
                         i.set(clazz_inst, constructor2.newInstance());
                     }

                 }*/

            //}
            /* for (Field i: clazz1.getDeclaredFields()){
                 i.setAccessible(true);
                 if (i.isAnnotationPresent(Inject.class)) {
                     Class<?> i_type = i.getType();

                     //Constructor<?> constructor2 = get_binded_class(i_type).getConstructor();
                     //constructor2.setAccessible(true);
                     i.set(clazz_inst, getComponent(i_type));}
                 /*for (Class<?> j: class_set){
                     if (j.equals(i_type)){
                         Constructor<?> constructor2 = j.getConstructor();
                         i.set(clazz_inst, constructor2.newInstance());
                     }

                 }*/

             //}
             //return clazz_inst;

        //}
        catch (NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException e) {
            System.out.println(e);
        }
     return null;
    }
}
