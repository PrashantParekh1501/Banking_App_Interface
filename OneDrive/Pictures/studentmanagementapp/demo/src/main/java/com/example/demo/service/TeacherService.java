package com.example.demo.service;

import com.example.demo.entities.Teacher;
import com.example.demo.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherService {

    @Autowired
    TeacherRepository TeacherRepository;

    public String addteacher(int id, Teacher teacher) {
        TeacherRepository.addteacher(id,teacher);
        return "teacher added successfully";

    }

    public List<Teacher> getallteacher() {
        return TeacherRepository.getallteacher();
    }

    public Teacher getteacherbyid(int id) {
       return TeacherRepository.getteacherbyid(id);
    }
}
