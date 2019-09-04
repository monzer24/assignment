package com.student.pojo;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
public class Student {

    public Student(String firstName, String lastName, String userName, String password, String major, float gpa, String gender) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.password = password;
        this.major = major;
        this.gpa = gpa;
        this.gender = gender;
    }

    public Student() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;
    private String firstName;
    private String lastName;
    private String userName;
    private String password;
    private String major;
    private float gpa;
    private String gender;

}
