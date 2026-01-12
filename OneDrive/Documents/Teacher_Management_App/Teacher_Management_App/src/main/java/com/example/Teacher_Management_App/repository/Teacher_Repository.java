package com.example.Teacher_Management_App.repository;

import com.example.Teacher_Management_App.model.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface Teacher_Repository extends JpaRepository<Teacher,Integer> {
}
