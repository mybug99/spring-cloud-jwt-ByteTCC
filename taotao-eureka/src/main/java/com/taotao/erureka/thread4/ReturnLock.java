package com.taotao.erureka.thread4;

import java.io.UnsupportedEncodingException;
import java.util.concurrent.*;

/**
 * @Description: 重入锁
 * @Author: 谷鑫丶Ryan
 * @CreateDate: 2019/5/14 11:15
 * @UpdateUser: 谷鑫丶Ryan
 * @UpdateDate: 2019/5/14 11:15
 * @Version: 1.0
 */
public class ReturnLock {

    public synchronized void a() {
        System.out.println("a-" + Thread.currentThread().getName());
        this.b();
        System.out.println("a==" + Thread.currentThread().getName());
    }

    public synchronized void b() {
        System.out.println("b-" + Thread.currentThread().getName());
    }

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        ReturnLock returnLock = new ReturnLock();

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                returnLock.a();
            }
        });

        executorService.execute(thread);
        Thread.sleep(1000);
        executorService.shutdown();
    }
}
