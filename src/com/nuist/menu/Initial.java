package com.nuist.menu;

import com.nuist.model.*;

import java.util.ArrayList;
import java.util.Scanner;

public class Initial {
    CoursesList coursesList = new CoursesList();
    ArrayList<Course> courses = new ArrayList<>();
    StudentsList studentsList = new StudentsList();
    ArrayList<Student> students = new ArrayList<>();
    TeachersList teachersList = new TeachersList();
    ArrayList<Teacher> teachers = new ArrayList<>();

    public CoursesList initialCoursesList() {
        courses.addLast(new Course("物理"));
        courses.addLast(new Course("化学"));
        coursesList.setCourseArrayList(courses);
        return coursesList;


    }
    public StudentsList initialStudentsList(){
        students.addLast(new Student(29, "jack", "29", "29"));
        students.addLast(new Student(31, "yaoxuan", "31", "31"));
        studentsList.setStudentArrayList(students);
        return studentsList;
    }
}
