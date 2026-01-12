package com.example.Teacher_Management_App.service;

import com.example.Teacher_Management_App.exceptions.TeacherNotFoundException;
import com.example.Teacher_Management_App.model.Teacher;
import com.example.Teacher_Management_App.repository.Teacher_Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class Teacher_Service {

    @Autowired
    Teacher_Repository teacherRepository;

    public Teacher addteacher(Teacher teacher) {
        return teacherRepository.save(teacher);
    }

    public Teacher getteacherbyrequestparam(int id) {
       return teacherRepository.findById(id).
               orElseThrow(() ->
                     new TeacherNotFoundException("teacher not found for this id"+ id)
        );
    }

    public String removeteacher(int id) {
        Teacher teacher = teacherRepository.findById(id).
                orElseThrow(() -> new TeacherNotFoundException("teacher not found for this id"+ id)
                );
        teacherRepository.delete(teacher);
        return "teacher successfully remove from this id"+id;
    }

    public List<String> getcollege(int id) {
       Teacher teacher = teacherRepository.findById(id).
               orElseThrow(() -> new TeacherNotFoundException("teacher not found for this id"+id)
               );
       return teacher.getCollege();
    }

    public Map<String, Integer> getAllProfNameWithSalary() {

        return teacherRepository.findAll()
                .stream()
                .collect(Collectors.toMap(
                        Teacher::getName,
                        Teacher::getIncome
                ));
    }
}
