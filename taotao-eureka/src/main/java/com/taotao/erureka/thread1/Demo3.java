package com.taotao.erureka.thread1;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

public class Demo3 implements Callable<Integer> {
    public static void main(String[] args) throws Exception {
        Demo3 d3 = new Demo3();
        FutureTask<Integer> future = new FutureTask<Integer>(d3);
        new Thread(future).start();
        Integer i = future.get();

        System.out.println("线程执行的结果="+i);
    }

    @Override
    public Integer call() throws Exception {
        int i = 5 * 6;
        System.out.println("结果" + i);
        return i;
    }
}