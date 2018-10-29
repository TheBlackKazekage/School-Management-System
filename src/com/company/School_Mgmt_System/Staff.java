package com.company.School_Mgmt_System;

public class Staff extends Person{
    private String staffIdNo;
    private String role;
    private String department;
    private int salary;

    //Constructor to get the user data upon construction of a new staff member
    public Staff(String staffIdNo, String role, String department, int salary){
        this.staffIdNo = staffIdNo;
        this.role = role;
        this.department = department;
        this.salary = salary;
    }

    public String getStaffIdNo() {
        return staffIdNo;
    }

    public void setStaffIdNo(String staffIdNo) {
        this.staffIdNo = staffIdNo;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "staffIdNo = " + staffIdNo + ", role = " + role +", department = " + department +", salary = " + salary;
    }
}
