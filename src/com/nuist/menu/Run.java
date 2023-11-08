package com.nuist.menu;

import java.sql.SQLOutput;
import java.util.Scanner;

public class Run {
    private String account = "123456";
    private String password = "123456";
    

    public static void main(String[] args) {
        Display disdplay = new Display();
        Run run = new Run();
        int option = disdplay.dispalyMenu();

            switch (option){
                case 0 -> System.out.println("bye");
                case 1 -> run.logIn();
                case 2 -> run.register();
                default ->  System.out.println("Invalid option entere. " + option);
            }
        }

    private void logIn(){
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
        }


    private void register(){
        System.out.println("Please enter your new account.");
        Scanner input2 = new Scanner(System.in);
        String account = input2.next();
        System.out.println("Please enter the password you want to set.");
        Scanner input3 = new Scanner(System.in);
        String password = input3.next();
        System.out.println("Please enter the password again to confirm.");
        Scanner input4 = new Scanner(System.in);
        String passwordConfirm = input4.next();
        if (password.equals(passwordConfirm)){
            System.out.println("You have created a new account successfully.");
        }
        else {
            System.out.println("The password you entered is not the same.");
        }
    }
}
