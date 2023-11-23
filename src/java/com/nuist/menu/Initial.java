package com.nuist.menu;

import com.nuist.model.*;

import java.util.ArrayList;
import java.util.Scanner;

public class Initial {
    CoursesArray coursesArray = new CoursesArray();
    String[] courses =new String[10];
    StudentsList studentsList = new StudentsList();
    ArrayList<Student> students = new ArrayList<>();
    TeachersList teachersList = new TeachersList();
    ArrayList<Teacher> teachers = new ArrayList<>();

    public String[] initialCoursesArray() {
        courses[0] = "乒乓球";
        courses[1] = "篮球";
        courses[2] = "游泳";
        courses[3] = "足球";
        courses[4] = "网球";
        coursesArray.setCoursesArray(courses);
        return coursesArray.getCoursesArray();
    }
    public StudentsList initialStudentsList(){
        students.add(0,new Student(29, "jack", "29", "29"));
        students.add(1,new Student(31, "yaoxuan", "31", "31"));
        studentsList.setStudentArrayList(students);
        return studentsList;
    }

    public TeachersList initialTeacherList(){
        teachers.add(0,new Teacher(123,"Dave","123","123"));
        teachersList.setTeacherArrayList(teachers);
        return teachersList;
    }
    //
}
