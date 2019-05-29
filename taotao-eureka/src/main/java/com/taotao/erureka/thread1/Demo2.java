package com.taotao.erureka.thread1;

public class Demo2 {
    public static void main(String[] args) {
        Thread thread = new Thread(new RunableDemo());
        thread.start();
    }
}

class RunableDemo implements Runnable {

    @Override
    public void run() {
        while (true)
            System.out.println("启动线程Runable接口" + Thread.currentThread().getName());
    }
}
