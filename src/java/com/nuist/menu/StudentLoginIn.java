package com.nuist.menu;

import com.nuist.model.Student;
import com.nuist.model.StudentsList;
import com.nuist.model.TeachersList;

import java.util.ArrayList;
import java.util.Scanner;

public class StudentLoginIn {
    ArrayList<Student> students = new ArrayList<>();
    Scanner input = new Scanner(System.in);
    public boolean logIn(boolean bool, StudentsList studentsList,String account,String password) {
        for (int i = 0; i < 3; i++) {
            students = studentsList.getStudentArrayList();
            //Implementing filtering search using a for loop to match a proper information
            for (int j = 0; j < students.size(); j++) {
                if (account.equals(students.get(j).getAccount()) && password.equals(students.get(j).getPassword())) {
                    System.out.println("Log in successfully.");
                    System.out.println("Login to the course selection system, please wait......");
                    System.out.println("Hello "+students.get(j).getStudentName()+"!");
                    return bool;
                }
            }
            System.out.println("The account or password is not correct ,please try again.");
            System.out.println("You have " + (2 - i+1) + " opportunities left.");

            System.out.println("Please enter your account.");
            account = input.next();

            System.out.println("Please enter your password.");
            password = input.next();
        }
        bool = false;
        return bool;
    }

    public Student getStudent(boolean bool,StudentsList studentsList,String account){
        students = studentsList.getStudentArrayList();
        Student response = null;
        if (bool){
            //Aslo implementing a flitering search
            for (int i = 0; i < students.size(); i++) {
                if (account.equals(students.get(i).getAccount())){
                    response = students.get(i);
                }
            }
        }
        return response;
    }
}
