package com.nuist.menu;

import com.nuist.model.*;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Initial {
    CoursesArray coursesArray = new CoursesArray();
    Course[] courses =new Course[5];
    StudentsList studentsList = new StudentsList();
    ArrayList<Student> students = new ArrayList<>();
    TeachersList teachersList = new TeachersList();
    ArrayList<Teacher> teachers = new ArrayList<>();

    XSSFWorkbook xssfWorkbook;

    {
        try {
            xssfWorkbook = new XSSFWorkbook(new FileInputStream("./List.xlsx"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public Course[] initialCoursesArray() {
        XSSFSheet sheet = xssfWorkbook.getSheetAt(2);

        int rowNum = sheet.getLastRowNum();
        int j = 0;
        for (int row = 1; row <= rowNum; row++) {

            String name = sheet.getRow(row).getCell(0).toString();
            String enrollment = sheet.getRow(row).getCell(1).toString();

            Course course = new Course(name, enrollment);
            courses[j] = course;

            j= j +1;
        }

        coursesArray.setCoursesArray(courses);
        return coursesArray.getCoursesArray();
    }
    public StudentsList initialStudentsList(){
        XSSFSheet sheet = xssfWorkbook.getSheetAt(0);

        int rowNum = sheet.getLastRowNum();
        System.out.println(rowNum);
        for (int row = 1; row <= rowNum; row++) {

            String id = sheet.getRow(row).getCell(0).toString();

            String name = sheet.getRow(row).getCell(1).toString();

            String account = sheet.getRow(row).getCell(2).toString();

            String password = sheet.getRow(row).getCell(3).toString();

            Student student = new Student(id,name,account,password);
            students.add(students.size(),student);
        }

        studentsList.setStudentArrayList(students);
        return studentsList;
    }

    public TeachersList initialTeacherList(){
        XSSFSheet sheet = xssfWorkbook.getSheetAt(1);

        int rowNum = sheet.getLastRowNum();
        for (int row = 1; row <= rowNum; row++) {

            String id = sheet.getRow(row).getCell(0).toString();

            String name = sheet.getRow(row).getCell(1).toString();

            String account = sheet.getRow(row).getCell(2).toString();

            String password = sheet.getRow(row).getCell(3).toString();

            Teacher teacher = new Teacher(id, name, account, password);
            teachers.add(teachers.size(),teacher);
        }

        teachersList.setTeacherArrayList(teachers);
        return teachersList;
    }
}
