package com.chx.tools.common.utils.testJVM.classLoader;

/**
 * @author yanjun
 * @date 2019/11/1 9:42
 **/
public class SingletonCopy {

    private static int counter1;

    private static int counter2 = 0;

    private static SingletonCopy singleton=new SingletonCopy();



    public SingletonCopy() {

        counter1++;

        counter2++;

    }

    public static int getCounter1() {

        return counter1;

    }

    public static int getCounter2() {

        return counter2;

    }


    public static SingletonCopy getInstance(){

        return singleton;

    }
}
