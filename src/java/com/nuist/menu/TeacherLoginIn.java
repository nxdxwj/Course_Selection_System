package com.nuist.menu;

import com.nuist.model.Teacher;
import com.nuist.model.TeachersList;

import java.util.ArrayList;
import java.util.Scanner;

public class TeacherLoginIn {
    ArrayList<Teacher> teachers = new ArrayList<>();
    Scanner input = new Scanner(System.in);
    String account;
    public boolean logIn(boolean bool, TeachersList teachersList) {
        for (int i = 0; i < 3; i++) {

            System.out.println("Please enter your account.");
            account = input.next();

            System.out.println("Please enter your password.");
            String password = input.next();


            teachers = teachersList.getTeacherArrayList();

            for (int j = 0; j < teachers.size(); j++) {
                if (account.equals(teachers.get(j).getAccount()) && password.equals(teachers.get(j).getPassword())) {
                    System.out.println("Log in successfully.");
                    return bool;
                }
            }
            System.out.println("The account or password is not correct ,please try again.");
            System.out.println("You have " + (2 - i) + " opportunities left.");
        }
        bool = false;
        return bool;
    }
}
