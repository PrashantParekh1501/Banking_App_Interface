package com.example.demo_sample;

public class Teacher {

    private int id;
    private String name;
    private int salary;
    private String subject;
    private int rating;

    public Teacher() {
    }

    public Teacher(int id, String name, int salary, String subject, int rating) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.subject = subject;
        this.rating = rating;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getSalary() {
        return salary;
    }

    public String getSubject() {
        return subject;
    }

    public int getRating() {
        return rating;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }
}
