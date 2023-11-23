package com.nuist.menu;

import com.nuist.model.*;

import java.util.ArrayList;
import java.util.Scanner;

public class Register {
    CoursesArray coursesList = new CoursesArray();
    ArrayList<Course> courses = new ArrayList<>();
    StudentsList studentsList = new StudentsList();
    ArrayList<Student> students = new ArrayList<>();
    TeachersList teachersList = new TeachersList();
    ArrayList<Teacher> teachers = new ArrayList<>();
    Scanner input = new Scanner(System.in);
    public boolean register (boolean bool,int choice,String account,String password,String passwordConfirm){



        while (!password.equals(passwordConfirm)) {
            System.out.println("The password you entered is not the same.");
            System.out.println("Please try again");
            System.out.println("Please enter the password you want to set.");
            password = input.next();
            System.out.println("Please enter the password again to confirm.");
            passwordConfirm = input.next();
        }


        switch (choice) {
            case 1:
                System.out.println("你的工号是：");
                int teacherId = input.nextInt();

                System.out.println("你的姓名是：");
                String teacherName = input.next();

                for (int i = 0; i < teachers.size(); i++) {
                    if (teacherId == teachers.get(i).getTeacherId() && teacherName.equals(teachers.get(i).getTeacherName()) && account.equals(teachers.get(i).getAccount()) && password.equals(teachers.get(i).getPassword())) {
                        System.out.println("你已经注册过该账号");
                        bool = false;
                    }
                }

                Teacher teacher = new Teacher(teacherId, teacherName, account, password);
                teachers.add(teachers.size(),teacher);
                teachersList.setTeacherArrayList(teachers);

                break;

            case 2:
                System.out.println("你的学号是：");
                int studentId = input.nextInt();

                System.out.println("你的姓名是：");
                String studentName = input.next();

                for (int i = 0; i < students.size(); i++) {
                    if (studentId == students.get(i).getStudentId() && studentName.equals(students.get(i).getStudentName()) && account.equals(students.get(i).getAccount()) && password.equals(students.get(i).getPassword())) {
                        System.out.println("你已经注册过该账号");
                        bool = false;
                        break;
                    }
                }
                Student student = new Student(studentId, studentName, account, password);
                students.add(students.size(),student);
                studentsList.setStudentArrayList(students);
        }
        System.out.println("You have created a new account successfully.");
        return bool;
    }
}