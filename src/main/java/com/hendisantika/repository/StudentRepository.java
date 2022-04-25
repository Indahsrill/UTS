package com.hendisantika.repository;

import com.hendisantika.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StudentRepository extends JpaRepository<Student,Long> {

    // Query method
    Optional<Student> findByEmail(String email);
}
