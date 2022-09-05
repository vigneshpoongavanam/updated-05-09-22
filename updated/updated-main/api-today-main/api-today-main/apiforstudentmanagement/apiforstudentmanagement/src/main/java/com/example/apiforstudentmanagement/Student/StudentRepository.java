package com.example.apiforstudentmanagement.Student;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

@Repository

public interface StudentRepository extends JpaRepository<Student,Long> {
   /* @Query(value = "Select * from tbl_student where email=?1",nativeQuery = true)
    Student AdminLogin(@PathVariable("email") String email);*/

   Optional<Student> findByEmail(@PathVariable("email") String email);
}
