package com.example.demo.service;

import com.example.demo.entities.Student;
import com.example.demo.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
     StudentRepository studentrepository;


    public String addstudent(int id, Student student) {
        return studentrepository.addstudent(id, student);
    }

    public Student getstudentbyid(int id) {
        return studentrepository.getstudentbyid(id);
    }

    public String updateage(int id, int age) {
        return studentrepository.updateage(id,age);
    }

    public  List<Student> getallstudents() {
        return studentrepository.getallstudents();
    }
}
