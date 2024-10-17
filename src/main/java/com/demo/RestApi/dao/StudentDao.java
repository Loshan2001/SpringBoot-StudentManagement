package com.demo.RestApi.dao;

import com.demo.RestApi.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentDao extends JpaRepository<Student,Integer> {

    List<Student> findAllByfirstName(String name);
}
