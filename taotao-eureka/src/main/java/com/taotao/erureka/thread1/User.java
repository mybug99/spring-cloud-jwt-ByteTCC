package com.taotao.erureka.thread1;

public class User {
    private int id;
    private String aa;
    private static int sex;

    public User(int id, String aa,int _sex) {
        this.id = id;
        this.aa = aa;
        sex=_sex;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAa() {
        return aa;
    }

    public void setAa(String aa) {
        this.aa = aa;
    }

    public static int getSex() {
        return sex;
    }

    public static void setSex(int sex) {
        User.sex = sex;
    }

    public User(){}
    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ",sex=" + sex +
                ", aa='" + aa + '\'' +
                '}';
    }
}
