package com.chx.tools.common.utils.testJVM;

/**
 * @author yanjun
 * @date 2019/10/24 9:34
 **/
public class MathTest {

    public static int initData = 678;
    public static HeapTest heapTest = new HeapTest();

    public int compute(){
        int a = 1;
        int b = 2;
        int c = (a + b) *initData;
        return c;
    }

    public static void main(String[] args) {
        MathTest mathTest = new MathTest();
        mathTest.compute();
    }
}
