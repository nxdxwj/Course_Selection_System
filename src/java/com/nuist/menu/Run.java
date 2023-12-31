package com.nuist.menu;


import com.nuist.model.*;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
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
        //Initialize course, student, and teacher related information
        Initial initialOperation = new Initial();
        Course[] courses = initialOperation.initialCoursesArray();
        studentsList= initialOperation.initialStudentsList();
        teachersList= initialOperation.initialTeacherList();

        //Display featured menu information
        Display disdplay = new Display();
        int option = disdplay.dispalyMenu();

        if (option==0){
            //Terminate Programming
            System.out.println("See you ~");
            System.exit(0);
        }

        //The additional menu to Confirm user's identity
        System.out.println("""
                    May I ask your identity：
                    1)teacher
                    2)student
                    """);
        int choice = input.nextInt();

        TeacherLoginIn teacherLoginIn = new TeacherLoginIn();
        StudentLoginIn studentLoginIn = new StudentLoginIn();

        Register registerOperation = new Register();

        switch (option) {
            //Log in the NUIST Course Selection System
            case 1:
                switch (choice){
                    //User is a teacher
                    case 1:
                        bool = teacherLoginIn.logIn(bool,teachersList);
                        break;
                    //User is a student
                    case 2:
                        System.out.println("Please enter your account.");
                        account = input.next()+".0";

                        System.out.println("Please enter your password.");
                        password = input.next()+".0";

                        bool=studentLoginIn.logIn(bool,studentsList,account,password);
                        break;
                    default:
                        System.out.println("Invalid choice entered.");
                }
                break;
            //Creat a new account
            case 2:
                System.out.println("Please enter your new account.");
                account = input.next()+".0";

                System.out.println("Please enter the password you want to set.");
                String password = input.next()+".0";

                System.out.println("Please enter the password again to confirm.");
                String passwordConfirm = input.next()+".0";

                registerOperation.register(bool,choice,account,password,passwordConfirm);
                break;
            default:
                System.out.println("Invalid option entered." + option);
                bool = false;
        }
        if (bool) {
            switch (choice) {
                //This is the teacher's query function
                case 1:
                    System.out.println("Here is the table showing your students' course selection information.");

                    String course1 = courses[0].getCourseName();
                    String course2 = courses[1].getCourseName();

                    Student student1 = studentsList.getStudentArrayList().get(0);
                    Student student2 = studentsList.getStudentArrayList().get(1);

                    System.out.println(student1.getStudentName() + " -> "+ course1);
                    System.out.println(student2.getStudentName() + " -> " + course2);
                    System.out.println();
                    runMenu();
                    break;
                //This is the course selection function for students
                case 2:
                    //Using Hash Tree Objects to achieve some kind of mapping relationship
                    HashMap<Student, String> map = new HashMap<>();

                    Student studentInformation = studentLoginIn.getStudent(bool, studentsList, account);

                    System.out.println("""
                            Here are the courses that can be selected. Please choose a course you are interested in：
                            1)table tennis
                            2)basketball
                            3)swimming
                            4)football
                            5)tennis
                            """);
                    String courseChoice = input.next();

                    for (int i = 0; i < courses.length; i++) {
                        if (courses[i].getCourseName().equals(courseChoice)) {

                            amountString = courses[i].getEnrollment();
                            double amountDouble = Double.parseDouble(amountString);
                            amount = (int) amountDouble;
                            amount++;
                            amountString = String.valueOf(amount);
                            break;
                        }
                    }
                    Course course = new Course(courseChoice, amountString);
                    map.put(studentInformation, course.getCourseName());

                    System.out.println("Course selecting successfully");
                    System.out.println();
                    runMenu();
                    //Attempting to achieve permanent data storage using external Excel files
                    try {
                        FileInputStream fileInputStream = new FileInputStream("./List.xlsx");
                        try {
                            XSSFWorkbook xssfWorkbook = new XSSFWorkbook(fileInputStream);
                            XSSFSheet sheet = xssfWorkbook.getSheetAt(2);
                            int rowNum = sheet.getLastRowNum();
                            for (int i = 1; i <= rowNum; i++) {
                                if (sheet.getRow(i).getCell(0).toString().equals(courseChoice)) {

                                    XSSFRow row = sheet.createRow(i);
                                    XSSFCell cell = row.createCell(1);
                                    System.out.println(amountString);
                                    cell.setCellValue(amountString);

                                    break;
                                }
                            }
                            FileOutputStream fileOutputStream = new FileOutputStream("/List.xlsx");
                            xssfWorkbook.write(fileOutputStream);
                            fileOutputStream.close();
                            System.out.println("Data updating completed！");

                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }

                    } catch (FileNotFoundException e) {
                        throw new RuntimeException(e);
                    }

            }
        }
        else {
            System.out.println("Returning to initial page, please wait~");
            System.out.println("-------------------");
            System.out.println();
            runMenu();
        }
    }

}
