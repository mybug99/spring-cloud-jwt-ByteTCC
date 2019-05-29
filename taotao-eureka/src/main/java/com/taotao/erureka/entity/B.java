package com.taotao.erureka.entity;

public class B extends A {
    public String name = "B";
    static {
        System.out.println("B的static");
    }

    public B(){
        System.out.println(this);
        System.out.println("B的无参");
    }


    public void bb(){
        System.out.println("====");
    }
}
