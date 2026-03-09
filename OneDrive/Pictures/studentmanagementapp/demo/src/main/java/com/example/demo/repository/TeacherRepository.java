package com.example.demo.repository;

import com.example.demo.entities.Teacher;
import com.example.demo.exceptions.Teachernotfoundexception;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class TeacherRepository {

    Map<Integer, Teacher> teacherdb = new HashMap<>();

    public String addteacher(int id, Teacher teacher) {
       if(teacherdb.containsKey(id)){
           return "this teacher already exist";
       }
       teacherdb.put(id, teacher);
       return "teacher added successfully";
    }

    public List<Teacher> getallteacher() {
        return new ArrayList<>(teacherdb.values());
    }

    public Teacher getteacherbyid(int id) {
        Teacher savedteacher = teacherdb.get(id);
        if(savedteacher == null){
            throw new Teachernotfoundexception("teacher is not in our db");
        }
        return savedteacher;
    }
}
