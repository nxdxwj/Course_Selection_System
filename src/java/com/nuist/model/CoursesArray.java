package com.nuist.model;

public class CoursesArray {
    private static String[] coursesArray = new String[10];

    public String[] getCoursesArray() {
        return coursesArray;
    }

    public void setCoursesArray(String[] coursesArray) {
        this.coursesArray = coursesArray;
    }

    public String getArrayElement(int index){
        return coursesArray[index];
    }
}
