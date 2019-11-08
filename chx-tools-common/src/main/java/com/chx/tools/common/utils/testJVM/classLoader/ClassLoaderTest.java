package com.chx.tools.common.utils.testJVM.classLoader;

/**
 * @author yanjun
 * @date 2019/11/1 9:43
 **/
public class ClassLoaderTest {
    public static void main(String[] args) {

        Singleton singleton=Singleton.getInstance();

        System.out.println("counter1:"+ Singleton.getCounter1());

        System.out.println("counter2:"+ Singleton.getCounter2());


        SingletonCopy singletonCopy=SingletonCopy.getInstance();

        System.out.println("counter11:"+ SingletonCopy.getCounter1());

        System.out.println("counter22:"+ SingletonCopy.getCounter2());


    }
}
