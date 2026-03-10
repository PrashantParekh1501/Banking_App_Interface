package com.example.demo_sample;

public class Student {

    private int id;   // primary key
    private String name;
    private int age;
    private int marks;

    // Default constructor is needed by Spring/Jackson
    public Student() {
    }

    public Student(int id, String name, int age, int marks) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.marks = marks;
    }

    // FIXED getters
    public int getId() {
        return id;   //  return the field, NOT getId()
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public int getMarks() {
        return marks;
    }

    // setters
    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setMarks(int marks) {
        this.marks = marks;
    }
}
