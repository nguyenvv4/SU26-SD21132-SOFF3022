package com.example.sd21102.repo;

import com.example.sd21102.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepo extends JpaRepository<Student, Integer> {

    @Query(value = "select * from students where fullName = :name", nativeQuery = true)
    List<Student> findByName(String name);
}
