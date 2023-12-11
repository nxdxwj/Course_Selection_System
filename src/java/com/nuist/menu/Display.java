
package com.nuist.menu;

import java.util.Scanner;

public class Display {
    public int dispalyMenu(){
        System.out.println("""
                Course Selection System
                Welcome~~~
                ------------------
                1) Log in the NUIST Course Selection System
                2) Creat a new account
                0)Exit
                (Please enter your option)
                ======>>             
                """
        );
        Scanner input = new Scanner(System.in);
        return  input.nextInt();



    }
}

