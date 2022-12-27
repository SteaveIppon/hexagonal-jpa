package com.ippon.hexagonal.infrastructure.secondary;

import com.ippon.hexagonal.domain.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    List<Student> findByEmail(String email);

}
