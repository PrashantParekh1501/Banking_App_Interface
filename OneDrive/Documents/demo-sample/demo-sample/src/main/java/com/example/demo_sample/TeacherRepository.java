package com.example.demo_sample;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class TeacherRepository {

    private Map<Integer, Teacher> teacherdb = new HashMap<>();

    public String addTeacher(Teacher teacher) {
        int id = teacher.getId();

        if (teacherdb.containsKey(id)) {
            return "Teacher already exists";
        }

        teacherdb.put(id, teacher);
        return "Teacher added successfully";
    }

    public Teacher getTeacherById(int id) {
        return teacherdb.get(id);
    }

    public String updateSalary(int id, int salary) {
        if (!teacherdb.containsKey(id)) {
            return "Invalid teacher ID";
        }

        Teacher existingTeacher = teacherdb.get(id);
        existingTeacher.setSalary(salary);
        return "Salary updated successfully";
    }

    public String updateRating(int id, int rating) {
        if (!teacherdb.containsKey(id)) {
            return "Invalid teacher ID";
        }

        Teacher existingTeacher = teacherdb.get(id);
        existingTeacher.setRating(rating);
        return "Rating updated successfully";
    }

    public List<Teacher> getAllTeachers() {
        return new ArrayList<>(teacherdb.values());
    }

    public String deleteTeacher(int id) {
        if (!teacherdb.containsKey(id)) {
            return "Teacher not found";
        }

        teacherdb.remove(id);
        return "Teacher removed successfully";
    }
}
