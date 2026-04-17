package com.example.restart.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.restart.Entity.StudentMan;

@Repository
public interface StudentManrepository extends JpaRepository<StudentMan,Long> {

}
