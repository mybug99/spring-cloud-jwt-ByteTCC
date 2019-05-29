package com.taotao.erureka.entity;

public class A {
    public String name = "A";
    static {
        System.out.println("A的static");
    }

    public A(){
        System.out.println(this);
        System.out.println("A的无参");
    }
    public  void aabb(){
        System.out.println("aabb");
    }
}
