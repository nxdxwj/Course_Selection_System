package com.nuist.model;

public class Teacher {
    private String teacherId;
    private String teacherName;

    private String account;
    private String password;

    public Teacher(String teacherId, String teacherName, String account, String password) {
        this.teacherId = teacherId;
        this.teacherName = teacherName;
        this.account = account;
        this.password = password;
    }

    public String getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(String teacherId) {
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
