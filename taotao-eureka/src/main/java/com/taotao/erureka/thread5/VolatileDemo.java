package com.taotao.erureka.thread5;

import static sun.misc.PostVMInitHook.run;

/**
 * @Description: class类作用描述
 * @Author: 谷鑫丶Ryan
 * @CreateDate: 2019/5/28 15:41
 * @UpdateUser: 谷鑫丶Ryan
 * @UpdateDate: 2019/5/28 15:41
 * @Version: 1.0
 */
public class VolatileDemo {

    public volatile int a = 1;


    public static void main(String[] args) throws InterruptedException {
        VolatileDemo volatileDemo = new VolatileDemo();
        for (int i = 0; i <100 ; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    volatileDemo.a++;
                    System.out.println(Thread.currentThread().getName());
                }
            }).start();
        }

        Thread.sleep(100);
        System.out.println(volatileDemo.a);
    }
}
