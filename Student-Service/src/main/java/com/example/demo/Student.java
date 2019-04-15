package com.example.demo;



public class Student
{
    private String name;
    private String secondName;
     
    public Student(String name, String secondName) {
        super();
        this.name = name;
        this.secondName = secondName;
    }
 
    public String getName() {
        return name;
    }
 
    public void setName(String name) {
        this.name = name;
    }
 
    public String getSecondName() {
        return secondName;
    }
 
    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }
}
