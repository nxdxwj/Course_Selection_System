package com.nuist.menu;

import com.nuist.model.*;

import java.util.ArrayList;
import java.util.Scanner;

public class Initial {
    ArrayList<Course> courses = new ArrayList<>();
    ArrayList<Student> students = new ArrayList<>();
    ArrayList<Teacher> teachers = new ArrayList<>();

    public void initial() {
        courses.addLast(new Course("物理"));
        courses.addLast(new Course("化学"));

        students.addLast(new Student(29, "jack", "29", "29"));
        students.addLast(new Student(31, "yaoxuan", "31", "31"));
    }
}
