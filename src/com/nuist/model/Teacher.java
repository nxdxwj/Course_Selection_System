package com.nuist.model;

public class Teacher {
    private int teacherId;
    private String teacherName;

    private String account;
    private String password;

    public Teacher(int teacherId, String teacherName, String account, String password) {
        this.teacherId = teacherId;
        this.teacherName = teacherName;
        this.account = account;
        this.password = password;
    }

    public int getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(int teacherId) {
        this.teacherId = teacherId;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
