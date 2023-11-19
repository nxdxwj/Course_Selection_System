package com.nuist.menu;

import com.nuist.model.Student;
import com.nuist.model.StudentsList;
import com.nuist.model.TeachersList;

import java.util.ArrayList;
import java.util.Scanner;

public class StudentLoginIn {
    ArrayList<Student> students = new ArrayList<>();
    Scanner input = new Scanner(System.in);

    String account;
    public boolean logIn(boolean bool, StudentsList studentsList) {
        for (int i = 0; i < 3; i++) {
            System.out.println("Please enter your account.");
            account = input.next();

            System.out.println("Please enter your password.");
            String password = input.next();


            students = studentsList.getStudentArrayList();

            for (int j = 0; j < students.size(); j++) {
                if (account.equals(students.get(j).getAccount()) && password.equals(students.get(j).getPassword())) {
                    System.out.println("Log in successfully.");
                    System.out.println("登录选课系统中，请稍后......");
                    System.out.println("Hello "+students.get(j).getStudentName()+"!");
                    return bool;
                }
            }
            System.out.println("The account or password is not correct ,please try again.");
            System.out.println("You have " + (2 - i) + " opportunities left.");
        }
        bool = false;
        return bool;
    }

    public Student getStudent(boolean bool,StudentsList studentsList,String account){
        students = studentsList.getStudentArrayList();
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
}
