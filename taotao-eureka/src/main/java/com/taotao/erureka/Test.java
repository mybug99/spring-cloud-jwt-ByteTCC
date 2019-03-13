package com.taotao.erureka;

public class Test {
    public static void main(String[] args) {
        for (int i = 1; i <= 7; i++) {
            if (i % 2 == 1) {
                System.out.print("\t");
                for (int k = 0; k < i; k++) {
                    System.out.print("*");
                }
                System.out.println();
            }
        }
    }
}
