package com.nuist.menu;

import com.nuist.model.*;

import java.util.ArrayList;
import java.util.Scanner;

public class Run {
    CoursesList coursesList = new CoursesList();
    ArrayList<Course> courses = new ArrayList<>();
    StudentsList studentsList = new StudentsList();
    ArrayList<Student> students = new ArrayList<>();
    TeachersList teachersList = new TeachersList();
    ArrayList<Teacher> teachers = new ArrayList<>();
    Scanner input = new Scanner(System.in);
    Boolean bool = true;

    private void initial() {
        courses.addLast(new Course("物理"));
        courses.addLast(new Course("化学"));

        students.addLast(new Student(29, "jack", "29", "29"));
        students.addLast(new Student(31, "yaoxuan", "31", "31"));
    }

    // 主程序
    public void runMenu() {
        initial();

        Display disdplay = new Display();
        int option = disdplay.dispalyMenu();

        switch (option) {
            case 0:
                System.out.println("See you ~");
                System.exit(0);
            case 1:
                logIn(bool);
            case 2:
                register(bool);
            default:
                System.out.println("Invalid option entere. " + option);
                bool = false;
        }
        if (bool) {

        }
    }

    private boolean logIn(boolean bool) {
        System.out.println("""
                    请问你的身份是：
                    1)教师
                    2)学生
                    """);
        int choice = input.nextInt();


        for (int i = 0; i < 3; i++) {
            System.out.println("Please enter your account.");
            String account = input.next();

            System.out.println("Please enter your password.");
            String password = input.next();

            switch (choice) {
                case 1:
                    teachers = teachersList.getTeacherArrayList();

                    for (int j = 0; j < teachers.size(); j++) {
                        if (account.equals(teachers.get(j).getAccount()) && password.equals(teachers.get(j).getPassword())) {
                            System.out.println("Log in successfully.");
                            break;
                        } else {
                            System.out.println("The account or password is not correct ,or you haven't own a login account.");
                            System.out.println("You have " + (2 - i) + " opportunities left.");
                            if (i == 2) {
                                System.out.println("The login opportunities have been used up.");
                                return bool = false;
                            }
                        }
                    }

                case 2:
                    students = studentsList.getStudentArrayList();

                    for (int j = 0; j < students.size(); j++) {
                        if (account.equals(students.get(j).getAccount()) && password.equals(students.get(j).getPassword())) {
                            System.out.println("Log in successfully.");
                            break;
                        } else {
                            System.out.println("The account or password is not correct.");
                            System.out.println("You have " + (2 - i) + " opportunities left.");
                            if (i == 2) {
                                System.out.println("The login opportunities have been used up.");
                                return bool = false;
                            }
                        }
                    }
            }

        }
        return bool;

    }

    private boolean register (boolean bool){
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

                Teacher teacher = new Teacher(teacherId, teacherName, account, password);
                teachers.addLast(teacher);
                teachersList.setTeacherArrayList(teachers);

                for (int i = 0; i < teachers.size(); i++) {
                    if (teacherId == teachers.get(i).getTeacherId() && teacherName.equals(teachers.get(i).getTeacherName()) && account.equals(teachers.get(i).getAccount()) && password.equals(teachers.get(i).getPassword())) {
                        System.out.println("你已经注册过该账号");
                        return bool = false;
                    }
                }

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
                        return bool = false;
                    }
                }
        }
        System.out.println("You have created a new account successfully.");
        return bool;
    }

}
