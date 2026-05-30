package com.example.sd21102.controller;

import com.example.sd21102.model.Student;
import com.example.sd21102.repo.StudentRepo;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class StudentController {

    @Autowired
    StudentRepo studentRepo;

    @GetMapping("/student")
    public String findAll(Model model) {

        List<Student> students = studentRepo.findAll();
        for (Student student : students) {
            System.out.println(student.toString());
        }
        model.addAttribute("students", students);

        return "student.html";
    }

    @GetMapping("/detail")
    public String getStudent(Model model) {
        Student student = new Student(1, "SD1123", "nguyenvv4@fpt.edu.vn", "UDPM", "Vu Van Nguyen", "0987654321", "PH1123");
        model.addAttribute("s", student);
        System.out.println(student.toString());
        return "student.html";
    }

    @PostMapping("/student/add")
    public String addStudent(Student student) {
        System.out.println(student.toString());
        studentRepo.save(student);
        // quay lai trang chu
        return "redirect:/student";
    }


    //===== su dung spring form======

    @GetMapping("/spring-form/student")
    public String springFormStudent(Model model, @ModelAttribute("student") Student student) {
        List<Student> students = studentRepo.findAll();
        model.addAttribute("students", students);
        return "student.html";
    }

    @PostMapping("/spring-form/student/add")
    public String springFormAddStudent(@ModelAttribute("student") @Valid Student student,
                                       Errors errors,
                                       Model model
    ) {
        if (errors.hasErrors()) {
            List<Student> students = studentRepo.findAll();
            model.addAttribute("students", students);
            model.addAttribute("message", "vui long sua cac loi sau");
            return "student.html";
        } else {
            studentRepo.save(student);
            // quay lai trang chu
            return "redirect:/spring-form/student";
        }
    }

    @GetMapping("/delete")
    public String deleteStudent(@RequestParam Integer id) {
        studentRepo.deleteById(id);
        return "redirect:/spring-form/student";
    }


}
