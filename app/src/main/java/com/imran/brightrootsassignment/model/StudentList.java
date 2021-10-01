package com.imran.brightrootsassignment.model;

public class StudentList {
    private String name;
    private String roll;

    public StudentList(String name, String roll) {
        this.name = name;
        this.roll = roll;
    }

    public String getRoll() {
        return roll;
    }

    public String getName() {
        return name;
    }
}
