package com.taotao.erureka.thread1;

public class Demo5 {
    public static void main(String[] args) {
        Thread t1 = new Thread(new Tager(),"t1");
        Thread t2 = new Thread(new Tager(),"t2");
       /* Thread t3 = new Thread(new Tager());
        Thread t4 = new Thread(new Tager());*/


        t1.setPriority(10);
        t2.setPriority(1);
        t1.start();
        t2.start();
    }
}

class Tager implements Runnable {

    @Override
    public void run() {
        while (true)
            System.out.println(Thread.currentThread().getName() + "....");
    }
}