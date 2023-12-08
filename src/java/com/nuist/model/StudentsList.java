package com.nuist.model;

import java.util.ArrayList;

public class StudentsList {
    //Using one of Collection Objects -> ArrayList,aiming to achieve multiple objects.
    private ArrayList<Student> studentArrayList;

    public ArrayList<Student> getStudentArrayList() {
        return studentArrayList;
    }

    public void setStudentArrayList(ArrayList<Student> studentArrayList) {
        this.studentArrayList = studentArrayList;
    }
}
