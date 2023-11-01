package com.nuist.menu;

import java.util.Scanner;

public class Display {
    private int option;

    public int dispalyMenu(){
        System.out.println("""
                Course Selection System
                Welcome~~~
                ------------------
                1) Log in the Course Selection Syst
                2) Creat a new account
                0)Exit
                (Please enter your option)
                ======>>             
                """
        );
        Scanner input = new Scanner(System.in);
        option = input.nextInt();

        return option;

    }
}
