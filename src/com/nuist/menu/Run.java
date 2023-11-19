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
    String account;
    // 主程序
    public void runMenu() {
        //初始化课程，学生，老师的相关信息
        Initial initialOperation = new Initial();
        coursesList=initialOperation.initialCoursesList();
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
                        studentLoginIn.logIn(bool,studentsList);
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

            HashMap<Student, Course> map = new HashMap<>();
            switch (choice) {
                case 1:
                    //这里是老师的查询功能
                    Course course1 = new Course("物理");
                    Course course2 = new Course("化学");
                    Student student1 = new Student(31, "yaoxuan" ,"31" ,"31");
                    Student student2 = new Student(29, "xuweijie" ,"29" ,"29");
                    map.put(student1 , course1);
                    map.put(student2 , course2);
                    map.get(student1);
                    map.get(student2);

                    break;

                case 2:
                    //这里是学生的选课功能
                    HashMap<Course, Integer> hashMap = new HashMap<>();

                    Student studentInformation = studentLoginIn.getStudent(bool,studentsList,account);

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
