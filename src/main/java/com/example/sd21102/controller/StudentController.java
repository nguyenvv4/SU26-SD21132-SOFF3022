package com.example.sd21102.controller;

import com.example.sd21102.model.Student;
import com.example.sd21102.model.Temp;
import com.example.sd21102.repo.StudentRepo;
import com.example.sd21102.repo.TempRepo;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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

    @Autowired
    TempRepo tempRepo;

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
    public String springFormStudent(Model model, @ModelAttribute("student") Student student,
                                    @RequestParam("page") int page) {
        // danh sach student
//        List<Student> students = studentRepo.findAll();
        // phan trang student
        Pageable pageable = PageRequest.of(page, 5);
        Page<Student> students = studentRepo.findAll(pageable);
        model.addAttribute("students", students);

        // test custom query
        List<Temp> list = tempRepo.getAllTemp();
        for (Temp temp : list) {
            System.out.println(temp.toString());
        }
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

    @GetMapping("/spring-form/student/detail")
    public String detailStudent(@RequestParam Integer id,
                                Model model) {
        Student student = studentRepo.findById(id).get(); // convert optional sang student
        model.addAttribute("st", student);
        return "student-detail.html";
    }

    @PostMapping("/spring-form/student/update")
    public String springFormUpdateStudent(@ModelAttribute("student") @Valid Student student,
                                          Errors errors,
                                          Model model
    ) {

        System.out.println(student.toString());
        studentRepo.save(student);
        // quay lai trang chu
        return "redirect:/spring-form/student";

    }



}
