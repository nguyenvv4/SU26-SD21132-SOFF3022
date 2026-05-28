package com.example.sd21102.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "students")
public class Student {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "ClassName")
    private String className;

    @Column(name = "email")
    private String email;

    @Column(name = "major")
    private String major;

    @Column(name = "fullName")
    private String fullName;

    @Column(name = "phone")
    @NotBlank(message = "so dien thoai khong duoc de trong")
    private String phone;

    @Column(name = "studentCode")
    private String studentCode;

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", className='" + className + '\'' +
                ", email='" + email + '\'' +
                ", major='" + major + '\'' +
                ", fullName='" + fullName + '\'' +
                ", phone='" + phone + '\'' +
                ", studentCode='" + studentCode + '\'' +
                '}';
    }
}
