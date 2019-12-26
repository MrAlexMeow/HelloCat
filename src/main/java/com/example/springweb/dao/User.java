package com.example.springweb.dao;

public class User {
    public String user_name;
    public String password;

    public String getSname() {
        return user_name;
    }

    public void setSname(String sname) {
        this.user_name = sname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                ", user_name='" + user_name + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
