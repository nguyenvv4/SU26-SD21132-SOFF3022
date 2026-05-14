package com.example.sd21102.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
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
