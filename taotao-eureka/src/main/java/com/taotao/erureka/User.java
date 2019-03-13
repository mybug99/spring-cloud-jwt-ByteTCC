package com.taotao.erureka;

public class User {
    public int id;
    public String aa;
    public static int sex;

    public User(int id, String aa,int _sex) {
        this.id = id;
        this.aa = aa;
        sex=_sex;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ",sex=" + sex +
                ", aa='" + aa + '\'' +
                '}';
    }
}
