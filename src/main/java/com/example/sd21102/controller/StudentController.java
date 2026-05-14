package com.example.sd21102.controller;

import com.example.sd21102.model.Student;
import com.example.sd21102.repo.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class StudentController {

    @Autowired
    StudentRepo studentRepo;

    @GetMapping("/student")
    public String findAll() {

        List<Student> students = studentRepo.findAll();
        for (Student student : students) {
            System.out.println(student.toString());
        }
        return null;
    }

}
