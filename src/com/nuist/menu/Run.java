package com.nuist.menu;


public class Run {
    Boolean bool = true;

    // 主程序
    public void runMenu() {
        Initial initialOperation = new Initial();
        initialOperation.initial();

        Display disdplay = new Display();
        int option = disdplay.dispalyMenu();

        LogIn logInOperation = new LogIn();

        Register registerOperation = new Register();


        switch (option) {
            case 0:
                System.out.println("See you ~");
                System.exit(0);
            case 1:
                logInOperation.logIn(bool);
            case 2:
                registerOperation.register(bool);
            default:
                System.out.println("Invalid option entere. " + option);
                bool = false;
        }
        if (bool) {
            switch (option) {
                case 0:
                    //这里是老师的查询功能




                case 1:
                    //这里是学生的选课功能
            }
        }
        else {
            runMenu();
        }
    }

}
