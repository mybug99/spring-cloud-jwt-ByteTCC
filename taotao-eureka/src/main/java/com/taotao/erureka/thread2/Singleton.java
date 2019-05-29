package com.taotao.erureka.thread2;

public class Singleton {

    //私有化构造方法
    private Singleton() {
    }

    private static Singleton singleton = new Singleton();

    public static Singleton getInstance() {
        return singleton;
    }
}
