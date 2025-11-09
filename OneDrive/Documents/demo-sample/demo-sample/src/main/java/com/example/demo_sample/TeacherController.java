package com.example.demo_sample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v2/teacher")
public class TeacherController {

    @Autowired
    private TeacherService teacherService;

    // Add new teacher
    @PostMapping
    public String addTeacher(@RequestBody Teacher teacher){
        return teacherService.addteacher(teacher);
    }

    //  Get teacher by ID using request parameter
    @GetMapping
    public Teacher getTeacherById(@RequestParam("id") int id){
        return teacherService.getteacherbyid(id);
    }

    //  Get teacher by ID using path variable
    @GetMapping("/{id}")
    public Teacher getTeacherByPath(@PathVariable int id){
        return teacherService.getteacherbyid(id);
    }

    //  Update salary using PUT
    @PutMapping("/id/{id}/salary/{salary}")
    public String updateSalary(@PathVariable int id, @PathVariable int salary){
        return teacherService.updatesalary(id, salary);
    }

    //  Update rating using PUT
    @PutMapping("/id/{id}/rating/{rating}")
    public String updateRating(@PathVariable int id, @PathVariable int rating){
        return teacherService.updateratings(id, rating);
    }

    // Get all teachers
    @GetMapping("/all")
    public List<Teacher> getAllTeachers(){
        return teacherService.getAllTeachers();
    }

    //  Delete teacher by ID
    @DeleteMapping("/{id}")
    public String deleteTeacher(@PathVariable int id){
        return teacherService.deleteteacher(id);
    }
}
