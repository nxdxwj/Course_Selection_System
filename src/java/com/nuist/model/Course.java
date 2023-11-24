package com.nuist.model;

public class Course {
    private String courseName;
    private String enrollment;

    public Course(String courseName, String enrollment) {
        this.courseName = courseName;
        this.enrollment = enrollment;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getEnrollment() {
        return enrollment;
    }

    public void setEnrollment(String enrollment) {
        this.enrollment = enrollment;
    }
}