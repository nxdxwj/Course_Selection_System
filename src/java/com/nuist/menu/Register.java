package com.nuist.menu;

import com.nuist.model.*;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
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
    XSSFWorkbook xssfWorkbook;

    {
        try {
            xssfWorkbook = new XSSFWorkbook(new FileInputStream("./List.xlsx"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

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
                String teacherId = input.next();

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

                XSSFSheet sheet = xssfWorkbook.getSheetAt(1);
                XSSFRow row = sheet.createRow(teachers.size()+1);

                XSSFCell cell = row.createCell(0);
                cell.setCellValue(teacherId);

                XSSFCell cell1 = row.createCell(1);
                cell1.setCellValue(teacherName);

                XSSFCell cell3 = row.createCell(2);
                cell3.setCellValue(account);

                XSSFCell cell4 = row.createCell(3);
                cell4.setCellValue(password);
                break;

            case 2:
                System.out.println("你的学号是：");
                String studentId = input.next();

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

                XSSFSheet sheet1 = xssfWorkbook.getSheetAt(0);
                XSSFRow row1 = sheet1.createRow(teachers.size()+1);

                XSSFCell cell00 = row1.createCell(0);
                cell00.setCellValue(studentId);

                XSSFCell cell11 = row1.createCell(1);
                cell11.setCellValue(studentName);

                XSSFCell cell33 = row1.createCell(2);
                cell33.setCellValue(account);

                XSSFCell cell44 = row1.createCell(3);
                cell44.setCellValue(password);
        }
        System.out.println("You have created a new account successfully.");
        return bool;
    }
}
