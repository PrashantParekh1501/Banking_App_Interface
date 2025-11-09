package com.example.demo_sample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherService {

    @Autowired
    TeacherRepository TeacherRepository;


    public String addteacher(Teacher Teacher) {
        return TeacherRepository.addTeacher(Teacher);
    }


    public Teacher getteacherbyid(int id) {
        return TeacherRepository.getTeacherById(id);
    }

    public String updatesalary(int id, int salary) {
        return TeacherRepository.updateSalary(id,salary);
    }

    public String updateratings(int id, int rating) {
        return TeacherRepository.updateRating(id,rating);
    }


    public List<Teacher> getAllTeachers() {
        return TeacherRepository.getAllTeachers();
    }

    public String deleteteacher(int id) {
        return TeacherRepository.deleteTeacher(id);
    }

}
