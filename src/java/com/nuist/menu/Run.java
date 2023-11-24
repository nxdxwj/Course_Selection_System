package com.nuist.menu;


import com.nuist.model.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Run {
    CoursesArray coursesArray = new CoursesArray();
    StudentsList studentsList = new StudentsList();
    TeachersList teachersList = new TeachersList();
    Boolean bool = true;
    Scanner input =new Scanner(System.in);
    String account;
    String password;
    // 主程序
    public void runMenu() {
        //初始化课程，学生，老师的相关信息
        Initial initialOperation = new Initial();
        initialOperation.initialCoursesArray();
        studentsList= initialOperation.initialStudentsList();
        teachersList= initialOperation.initialTeacherList();
        //
        System.out.println("""
                    请问你的身份是：
                    1)教师
                    2)学生
                    """);
        int choice = input.nextInt();

        Display disdplay = new Display();
        int option = disdplay.dispalyMenu();

        TeacherLoginIn teacherLoginIn = new TeacherLoginIn();
        StudentLoginIn studentLoginIn = new StudentLoginIn();

        Register registerOperation = new Register();

        switch (option) {
            case 0:
                System.out.println("See you ~");
                System.exit(0);
            case 1:
                switch (choice){
                    case 1:
                        teacherLoginIn.logIn(bool,teachersList);
                        break;
                    case 2:
                        System.out.println("Please enter your account.");
                        account = input.next();

                        System.out.println("Please enter your password.");
                        password = input.next();

                        bool=studentLoginIn.logIn(bool,studentsList,account,password);
                        break;
                    default:
                        System.out.println("Invalid choice entered.");
                }
                break;
            case 2:
                System.out.println("Please enter your new account.");
                account = input.next();

                System.out.println("Please enter the password you want to set.");
                String password = input.next();

                System.out.println("Please enter the password again to confirm.");
                String passwordConfirm = input.next();

                registerOperation.register(bool,choice,account,password,passwordConfirm);
                break;
            default:
                System.out.println("Invalid option entered." + option);
                bool = false;
        }
        if (bool) {
            switch (choice) {
                case 1:
                    //这里是老师的查询功能
//                    System.out.println("Here is the table showing your students' course selection information.");
//                    Course[] coursearry = coursesArray.getCoursesArray();
//                    String course1 = coursesArray.getCoursesArray()[0];
//                    String course2 = coursesArray.getArrayElement(1);
//
//                    Student student1 = studentsList.getStudentArrayList().get(0);
//                    Student student2 = studentsList.getStudentArrayList().get(1);
//
//                    System.out.println(student1.getStudentName() +  course1);
//                    System.out.println(student2.getStudentName() +  course2);
//                    break;

                case 2:
                    //这里是学生的选课功能

                    HashMap<Student, Course> map = new HashMap<>();

                    Student studentInformation = studentLoginIn.getStudent(bool,studentsList,account);

                    System.out.println("""
                            下面是可以选择的课程,请回复课程名称：
                            1)物理
                            2)化学
                            """);
                    String courseChoice = input.next();
//
//                    amount = amount+1;
//
//                    map.put(studentInformation,course);

                    System.out.println("选课成功");
            }
        }
        else {
            System.out.println("正在返回初始页面，请稍候");
            System.out.println("-------------------");
            runMenu();
        }
    }

}
