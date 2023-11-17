package com.nuist.menu;

import com.nuist.model.Student;
import com.nuist.model.StudentsList;
import com.nuist.model.Teacher;
import com.nuist.model.TeachersList;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Scanner;

public class Run {
    private String account = "123456";
    private String password = "123456";

    public void runMenu(){
        Display disdplay = new Display();
        Run run = new Run();
        int option = disdplay.dispalyMenu();

        switch (option){
            case 0 -> System.out.println("See you ~");
            case 1 -> run.logIn();
            case 2 -> run.register();
            default ->  System.out.println("Invalid option entere. " + option);
            }
    }


    private void logIn(){
        Scanner input = new Scanner(System.in);
        System.out.println("""
                请问你的身份是：
                1)教师
                2)学生
                """);
        int identity = input.nextInt();

        for (int i = 0; i < 3;i++){
            System.out.println("Please enter your account.");
            Scanner sc = new Scanner(System.in);
            String account = sc.next();
            System.out.println("Please enter your password.");
            String password = sc.next();
            if (account.equals(this.account) && password.equals(this.password) ) {
                System.out.println("Log in successfully.");
                    break;
                }
                else{
                    System.out.println("The account or password is not correct.");
                    System.out.println("You have "+(2-i)+" opportunities left.");
                    if (i == 2){
                        System.out.println("The login opportunities have been used up.");
                    }
                }
            }
        switch(identity){
        //    case 1 ->
        //    case 2 ->
        }


        }


    private void register(){
        Run run = new Run();

        System.out.println("Please enter your new account.");
        Scanner input = new Scanner(System.in);
        String account = input.next();
        System.out.println("Please enter the password you want to set.");
        String password = input.next();
        System.out.println("Please enter the password again to confirm.");
        String passwordConfirm = input.next();
        while (! password.equals(passwordConfirm)) {
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
//            case 1 ->;
            case 2 -> run.addStudent();
        }
        System.out.println("You have created a new account successfully.");
    }
    private void addStudent(){
        Student student = new Student();
        System.out.println("你的学号是：");
        Scanner input = new Scanner(System.in);
        int studentId = input.nextInt();
        System.out.println("你的姓名是：");
        String studentName = input.next();
        student.setStudentId(studentId);
        student.setStudentName(studentName);
        StudentsList studentsList = new StudentsList();
        ArrayList<Student> students = new ArrayList<>();
        students.addLast(student);
        studentsList.setStudentArrayList(students);
        System.out.println(students);
    }
    private void addTeacher() {
        Teacher teacher = new Teacher();
        System.out.println("你的工号是：");
        Scanner input = new Scanner(System.in);
        int teacherId = input.nextInt();
        System.out.println("你的姓名是：");
        String teacherName = input.next();
        teacher.setTeacherId(teacherId);
        teacher.setTeacherName(teacherName);
        TeachersList teachersList = new TeachersList();
        ArrayList<Teacher> teachers = new ArrayList<>();
        teachers.addLast(teacher);
        teachersList.setTeacherArrayList(teachers);
        System.out.println(teachers);
    }

    private void authenticationStudent(){
        Scanner input = new Scanner(System.in);
        System.out.println("Please enter your student ID");
        String studentID = input.next();


    }

    private void authenticationTeacher(){}
}
