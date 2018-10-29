package com.company.School_Mgmt_System;

public class Student extends Person{
    private String studentIdNo;
    private String course;
    private String level;
    private String points;

    //Constructor of the student object that collects the data of the new student object
    public Student(String studentIdNo, String course, String level, String points){
        this.studentIdNo = studentIdNo;
        this.course = course;
        this.level = level;
        this.points = points;
    }

    public String getStudentIdNo() {
        return studentIdNo;
    }

    public void setStudentIdNo(String studentIdNo) {
        this.studentIdNo = studentIdNo;
    }

    public String getPoints() {
        return points;
    }

    public void setPoints(String points) {
        this.points = points;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    @Override
    public String toString() {
        return "studentId = " + studentIdNo + ", course = " + course +", year = " + level +", points = " + points;
    }
}
