package com.taotao.erureka.thread1;

public class Demo6 {
    private static volatile int value = 0;

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 1000; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    value++;
                    System.out.println(Thread.currentThread().getName()+" ... "+value);
                }
            }).start();
        }
        Thread.sleep(2000);
        System.out.println(value);
    }
}
