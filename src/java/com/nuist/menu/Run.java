package com.nuist.menu;


import com.nuist.model.*;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
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
    int amount;
    String amountString = null;
    // 主程序
    public void runMenu() {
        //初始化课程，学生，老师的相关信息
        Initial initialOperation = new Initial();
        Course[] courses = initialOperation.initialCoursesArray();
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

                    HashMap<Student, String> map = new HashMap<>();

                    Student studentInformation = studentLoginIn.getStudent(bool, studentsList, account);

                    System.out.println("""
                            下面是可以选择的课程,请回复课程名称：
                            1)乒乓球
                            2)篮球
                            3)游泳
                            4)足球
                            5)网球
                            """);
                    String courseChoice = input.next();

                    for (int i = 0; i < courses.length; i++) {
                        if (courses[i].getCourseName().equals(courseChoice)) {

                            amountString = courses[i].getEnrollment();
                            double amountDouble = Double.parseDouble(amountString);
                            amount = (int) amountDouble;
                            amount++;


                            break;
                        }
                    }
                    Course course = new Course(courseChoice, amountString);
                    map.put(studentInformation, course.getCourseName());

                    System.out.println("选课成功");


                    try {
                        FileInputStream fileInputStream = new FileInputStream("./List.xlsx");
                        try {
                            XSSFWorkbook xssfWorkbook = new XSSFWorkbook(fileInputStream);
                            XSSFSheet sheet = xssfWorkbook.getSheetAt(2);
                            int rowNum = sheet.getLastRowNum();
                            for (int i = 1; i < rowNum; i++) {
                                if (sheet.getRow(i).getCell(0).toString().equals(courseChoice)) {
                                    XSSFCell cell = sheet.getRow(i).getCell(1);
                                    cell.setCellValue(amountString);
                                    break;
                                }
                            }
                            FileOutputStream fileOutputStream = new FileOutputStream("/List.xlsx");
                            xssfWorkbook.write(fileOutputStream);
                            fileOutputStream.close();
                            System.out.println("数据更新完成！");

                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }

                    } catch (FileNotFoundException e) {
                        throw new RuntimeException(e);
                    }


            }
        }
        else {
            System.out.println("正在返回初始页面，请稍候");
            System.out.println("-------------------");
            runMenu();
        }
    }

}
