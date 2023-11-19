package com.nuist.menu;

import com.nuist.model.*;

import java.util.ArrayList;
import java.util.Scanner;

public class LogIn {
    CoursesList coursesList = new CoursesList();
    ArrayList<Course> courses = new ArrayList<>();
    StudentsList studentsList = new StudentsList();
    ArrayList<Student> students = new ArrayList<>();
    TeachersList teachersList = new TeachersList();
    ArrayList<Teacher> teachers = new ArrayList<>();
    Scanner input = new Scanner(System.in);
    String account;
    public Student getStudent(boolean bool,int choice,StudentsList studentsList){
        Student response = null;
        if (bool){
                    for (int i = 0; i < students.size(); i++) {
                        if (account.equals(students.get(i).getAccount())){
                            response = students.get(i);
                        }
                    }
            }
        return response;
    }
    public boolean logIn(boolean bool, int choice, TeachersList teachersList) {
        for (int i = 0; i < 3; i++) {
            System.out.println("Please enter your account.");
            account = input.next();

            System.out.println("Please enter your password.");
            String password = input.next();

            switch (choice) {
                case 1:
                    teachers = this.teachersList.getTeacherArrayList();

                    for (int j = 0; j < teachers.size(); j++) {
                        if (account.equals(teachers.get(j).getAccount()) && password.equals(teachers.get(j).getPassword())) {
                            System.out.println("Log in successfully.");
                            break;
                        } else {
                            System.out.println("The account or password is not correct ,please try again.");
                            System.out.println("You have " + (2 - i) + " opportunities left.");
                        }
                        bool = false;
                    }

                case 2:
                    students = studentsList.getStudentArrayList();

                    for (int j = 0; j < students.size(); j++) {
                        if (account.equals(students.get(j).getAccount()) && password.equals(students.get(j).getPassword())) {
                            System.out.println("Log in successfully.");
                            return bool;
                        } else {
                            System.out.println("The account or password is not correct,please try again.");
                            System.out.println("You have " + (2 - i) + " opportunities left.");
                        }
                    }
                    bool = false;
            }
        }
        return bool;
    }
}
