package com.badr.student;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SudentRepository extends JpaRepository<Student,Integer> {
}
