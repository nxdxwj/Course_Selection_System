package com.nuist.menu;

import com.nuist.model.*;

import java.util.ArrayList;
import java.util.Scanner;

public class Register {
    CoursesList coursesList = new CoursesList();
    ArrayList<Course> courses = new ArrayList<>();
    StudentsList studentsList = new StudentsList();
    ArrayList<Student> students = new ArrayList<>();
    TeachersList teachersList = new TeachersList();
    ArrayList<Teacher> teachers = new ArrayList<>();
    Scanner input = new Scanner(System.in);
    public boolean register (boolean bool){
        System.out.println("Please enter your new account.");

        String account = input.next();
        System.out.println("Please enter the password you want to set.");
        String password = input.next();

        System.out.println("Please enter the password again to confirm.");
        String passwordConfirm = input.next();


        while (!password.equals(passwordConfirm)) {
            System.out.println("The password you entered is not the same.");
            System.out.println("Please try again");
            System.out.println("Please enter the password you want to set.");
            password = input.next();
            System.out.println("Please enter the password again to confirm.");
            passwordConfirm = input.next();
        }

        System.out.println("""
                        请问你的身份是：
                        1)教师
                        2)学生
                        """);
        int identity = input.nextInt();

        switch (identity) {
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
                teachers.addLast(teacher);
                teachersList.setTeacherArrayList(teachers);

                break;

            case 2:
                System.out.println("你的学号是：");
                int studentId = input.nextInt();

                System.out.println("你的姓名是：");
                String studentName = input.next();

                Student student = new Student(studentId, studentName, account, password);
                students.addLast(student);
                studentsList.setStudentArrayList(students);

                for (int i = 0; i < students.size(); i++) {
                    if (studentId == students.get(i).getStudentId() && studentName.equals(students.get(i).getStudentName()) && account.equals(students.get(i).getAccount()) && password.equals(students.get(i).getPassword())) {
                        System.out.println("你已经注册过该账号");
                        bool = false;
                        break;
                    }
                }
        }
        System.out.println("You have created a new account successfully.");
        return bool;
    }
}
