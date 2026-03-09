package com.example.demo.repository;

import com.example.demo.entities.Student;
import com.example.demo.exceptions.existstudentexception;
import com.example.demo.studentnotfoundexception;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class StudentRepository {


    Map<Integer, Student> studentdb = new HashMap<>();

    public String addstudent(int id, Student student) {
         if(studentdb.containsKey(id)){
             throw new existstudentexception("this student already enroll", HttpStatus.BAD_REQUEST);
         }
         studentdb.put(id, student);
         return "student added successfully";
    }

    public Student getstudentbyid(int id) {
       if(!studentdb.containsKey(id)){
           throw new studentnotfoundexception("thid student info I can't get it"+ id, HttpStatus.OK);
       }
      Student savedstudent = studentdb.get(id);
       return savedstudent;
    }

    public String updateage(int id,int age) {
        Student savedstudent = studentdb.get(id);
        savedstudent.setAge(age);
        return "student age update successfully";
    }

    public List<Student> getallstudents() {
        return new ArrayList(studentdb.values());
    }
}
