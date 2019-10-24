package com.chx.tools.common.utils.testJVM;

import java.util.ArrayList;

/**
 * @author yanjun
 * @date 2019/10/24 9:13
 **/
public class HeapTest {

    //声明一个100KB的数组
    byte[] a = new byte[1024*100];

    public static void main(String[] args) throws InterruptedException {
        ArrayList<HeapTest> heapTests = new ArrayList<>();
        while (true){
            heapTests.add(new HeapTest());
            Thread.sleep(10L);
        }
    }
}
