package com.taotao.erureka.thread3;

/**
 * @Description: 懒汉式单例测试
 * @Author: 谷鑫丶Ryan
 * @CreateDate: 2019/5/8 17:36
 * @UpdateUser: 谷鑫丶Ryan
 * @UpdateDate: 2019/5/8 17:36
 * @Version: 1.0
 */
public class Singleton {

    private Singleton() {
    }

    private static Singleton singleton;

    public static Singleton getInstance() throws InterruptedException {
        synchronized (Singleton.class) {
            if (singleton == null) {
                singleton = new Singleton();
            }
        }
        return singleton;
    }
}
