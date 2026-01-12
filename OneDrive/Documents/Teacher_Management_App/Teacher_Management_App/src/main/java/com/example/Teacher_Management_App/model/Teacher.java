package com.example.Teacher_Management_App.model;



import jakarta.persistence.*;

import java.util.List;
import java.util.Map;

@Entity
public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String name;

    @Column
    private String sub;

    @ElementCollection
    private List<String> college;

    @Column
    private Integer income;

    @Column
    private Integer rating;

    public Teacher() {}

    public Teacher(Integer id, String name, String sub, List<String> college,
                   Integer income, Integer rating) {
        this.id = id;
        this.name = name;
        this.sub = sub;
        this.college = college;
        this.income = income;
        this.rating = rating;
    }

    public Integer getId() { return id; }
    public String getName() { return name; }
    public String getSub() { return sub; }
    public List<String> getCollege() { return college; }
    public Integer getIncome() { return income; }
    public Integer getRating() { return rating; }

    public void setId(Integer id) { this.id = id; }
    public void setName(String name) { this.name = name; }
    public void setSub(String sub) { this.sub = sub; }
    public void setCollege(List<String> college) { this.college = college; }
    public void setIncome(Integer income) { this.income = income; }
    public void setRating(Integer rating) { this.rating = rating; }

}
