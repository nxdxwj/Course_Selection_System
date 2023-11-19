package com.nuist.menu;


import com.nuist.model.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Run {
    CoursesList coursesList = new CoursesList();
    StudentsList studentsList = new StudentsList();
    TeachersList teachersList = new TeachersList();
    Boolean bool = true;
    Scanner input =new Scanner(System.in);
    Integer amount = 0;
    // 主程序
    public void runMenu() {
        //初始化课程，学生，老师的相关信息
        Initial initialOperation = new Initial();
        coursesList=initialOperation.initialCoursesList();
        studentsList= initialOperation.initialStudentsList();

        Display disdplay = new Display();
        int option = disdplay.dispalyMenu();

        TeacherLoginIn teacherLoginIn = new TeacherLoginIn();
        StudentLoginIn studentLoginIn = new StudentLoginIn();

        Register registerOperation = new Register();

        System.out.println("""
                    请问你的身份是：
                    1)教师
                    2)学生
                    """);
        int choice = input.nextInt();

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
                        studentLoginIn.logIn(bool,studentsList);
                        break;
                }
                break;
            case 2:
                registerOperation.register(bool);
                break;
            default:
                System.out.println("Invalid option entere. " + option);
                bool = false;
        }
        if (bool) {

            switch (option) {
                case 0:
                    //这里是老师的查询功能





                case 1:
                    //这里是学生的选课功能
                    HashMap<Student, Course> map = new HashMap<>();
                    HashMap<Course, Integer> hashMap = new HashMap<>();


                    Student studentInformation = studentLoginIn.getStudent(bool,studentsList);

                    System.out.println("""
                            下面是可以选择的课程,请回复课程名称：
                            1)物理
                            2)化学
                            """);
                    String courseChoice = input.next();
                    Course course = new Course(courseChoice);
                    amount = amount+1;

                    map.put(studentInformation,course);
                    hashMap.put(course,amount);

                    System.out.println("选课成功");
            }
        }
        else {
            runMenu();
        }
    }

}