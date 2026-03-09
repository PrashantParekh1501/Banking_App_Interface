package com.example.demo.controllers;

import com.example.demo.entities.Teacher;
import com.example.demo.exceptions.Teacheralreadyexistexception;
import com.example.demo.exceptions.Teachernotfoundexception;
import com.example.demo.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class TeacherController {

    @Autowired
    TeacherService TeacherService;

    @PostMapping("/teacher/{id}")
    public ResponseEntity<String> addteacher(@PathVariable int id, @RequestBody Teacher Teacher){
        try{
            return new ResponseEntity(TeacherService.addteacher(id,Teacher), HttpStatus.OK);
        }
        catch (Teacheralreadyexistexception e){
            return new ResponseEntity(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/allteacher")
    public ResponseEntity<String> getallteacher(){
        try{
            return new ResponseEntity(TeacherService.getallteacher(), HttpStatus.OK);
        }
        catch (NullPointerException e){
            return new ResponseEntity(e.getMessage(), HttpStatus.NO_CONTENT);
        }
    }

    @GetMapping("/teacherinfo/{id}")
    public ResponseEntity<Teacher> getteacherbyid(@RequestParam("id") int id){
        try{
            return new ResponseEntity<>(TeacherService.getteacherbyid(id), HttpStatus.OK);
        }
        catch (Teachernotfoundexception e){
            return new ResponseEntity(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }





}
