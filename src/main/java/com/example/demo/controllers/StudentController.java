package com.example.demo.controllers;

import com.example.demo.entities.Student;
import com.example.demo.exceptions.existstudentexception;
import com.example.demo.service.StudentService;
import com.example.demo.studentnotfoundexception;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@RestController
@RequestMapping("/api/v1")
public class StudentController {


    @Autowired
    StudentService studentservice;

    Map<Integer, Student>studentdb = new HashMap<>();

    @GetMapping("/welcome")
    public String getwelcome(){
        return "hello world";
    }

    @PostMapping("/enroll")
    public ResponseEntity<String> addstudent(@RequestParam("id") int id, @RequestBody Student student){
        try{
            return new ResponseEntity(studentservice.addstudent(id,student), HttpStatus.OK);
        }
        catch (existstudentexception e){
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/student/{id}")
    public ResponseEntity<Student> getstudentbyid(@PathVariable  int id){
        try{
            return new ResponseEntity(studentservice.getstudentbyid(id), HttpStatus.OK);
        }
        catch (studentnotfoundexception e){
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    //using requestparam get student data
    @GetMapping("student{id}")
    public ResponseEntity<Student> getstudentbyreqparam(@RequestParam("id") int id){
        try{
            return new ResponseEntity(studentservice.getstudentbyid(id), HttpStatus.OK);
        }
        catch (studentnotfoundexception e){
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    //update age
    @PutMapping("/student/{id}/{age}")
    public ResponseEntity<String> updateage(@PathVariable int age, @PathVariable int id){
        try{
            return new ResponseEntity<>(studentservice.updateage(age,id), HttpStatus.OK);
        }
        catch (studentnotfoundexception e){
           return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("letit")
    public ResponseEntity<String> updateagebyreqparam(@RequestParam("age") int age, @RequestParam("id") int id){
        try{
            return new ResponseEntity<>(studentservice.updateage(age, id), HttpStatus.OK);
        }
        catch (studentnotfoundexception e){
           return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/all")
    public ResponseEntity<List<Student>> getallstudents() {

        List<Student> students = studentservice.getallstudents();

        if(students == null || students.isEmpty()){
            return new ResponseEntity("stdent db is empty",HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity(students, HttpStatus.OK);
    }


}
