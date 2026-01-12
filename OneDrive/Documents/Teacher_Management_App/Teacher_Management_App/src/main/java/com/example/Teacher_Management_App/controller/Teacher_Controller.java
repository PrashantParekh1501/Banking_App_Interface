package com.example.Teacher_Management_App.controller;

import com.example.Teacher_Management_App.exceptions.TeacherNotFoundException;
import com.example.Teacher_Management_App.model.Teacher;
import com.example.Teacher_Management_App.service.Teacher_Service;
import org.hibernate.Remove;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("api/v1")
public class Teacher_Controller {

      @Autowired
      Teacher_Service teacherService;

    @PostMapping("/add")
    public ResponseEntity<Teacher> addteacher(@RequestBody Teacher teacher){

        return new ResponseEntity(teacherService.addteacher(teacher), HttpStatus.CREATED);
    }

    @GetMapping("/get_by_param")
    public ResponseEntity<Teacher> getteacherbyrequestparam(@RequestParam("id") int id){
       Teacher teacher = teacherService.getteacherbyrequestparam(id);
       return ResponseEntity.ok(teacher);
    }

    @GetMapping("/get_by_path")
    public ResponseEntity<Teacher> getteacherbypathvariable(@PathVariable int id){
        Teacher teacher = teacherService.getteacherbyrequestparam(id);
        return ResponseEntity.ok(teacher);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<String> removeteacher(@PathVariable int id){
        try{
            String response = teacherService.removeteacher(id);
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        catch (TeacherNotFoundException e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<List<String>> getcollege(@PathVariable int id) {
        List<String> colleges = teacherService.getcollege(id);
        return ResponseEntity.ok(colleges);
    }


    @GetMapping("/prof-salary")
    public ResponseEntity<Map<String, Integer>> getAllProfSalary() {
        return ResponseEntity.ok(
                teacherService.getAllProfNameWithSalary()
        );
    }

}
