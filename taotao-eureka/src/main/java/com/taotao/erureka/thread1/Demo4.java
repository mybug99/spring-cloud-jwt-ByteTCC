package com.taotao.erureka.thread1;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Demo4 {

    public static void main(String[] args) {
        ExecutorService threadPool = Executors.newCachedThreadPool();

        for (int i = 0; i < 20; i++) {
            threadPool.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println("打印线程" + Thread.currentThread().getName());
                }
            });
        }
        threadPool.shutdown();

    }
}
