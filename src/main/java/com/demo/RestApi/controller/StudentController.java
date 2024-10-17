package com.demo.RestApi.controller;

import com.demo.RestApi.dao.StudentDao;
import com.demo.RestApi.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {


    @Autowired
    private final StudentDao studentDao;

    public StudentController(StudentDao studentDao) {
        this.studentDao = studentDao;
    }

    @PostMapping("/create")
    public Student createStudent(@RequestBody Student student){
        return  studentDao.save(student);
    }
}
