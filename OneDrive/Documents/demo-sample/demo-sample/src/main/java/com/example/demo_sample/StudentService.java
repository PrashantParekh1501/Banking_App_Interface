package com.example.demo_sample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentRepository repo;

    public Student getStudentById(int id) {
        return repo.getStudentById(id);
    }

    public String addStudent(Student student) {
        return repo.addStudent(student);
    }

    public String updateAge(int id, int age) {
        return repo.updateAge(id, age);
    }

    public List<Student> getAllStudents() {
        return repo.getAllStudents();
    }

    public String deleteStudent(int id) {
        return repo.deleteStudent(id);
    }
}
