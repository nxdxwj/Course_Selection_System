package com.nuist.model;

public class Student {
    private int studentId;
    private String studentName;
    private String account;
    private String password;

    public Student(int studentId, String studentName, String account, String password) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.account = account;
        this.password = password;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
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
