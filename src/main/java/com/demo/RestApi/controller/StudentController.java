package com.demo.RestApi.controller;

import com.demo.RestApi.dao.StudentDao;
import com.demo.RestApi.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {


    @Autowired
    private final StudentDao studentDao;

    public StudentController(StudentDao studentDao) {
        this.studentDao = studentDao;
    }

    @PostMapping("/student/create")
    public Student createStudent(@RequestBody Student student){
        return  studentDao.save(student);
    }

    @GetMapping("/student/getAll")
    public List<Student> getAllStudents(){
        return studentDao.findAll();
    }

    @GetMapping("/student/getStudent/{id}")
    public Student getStudent(@PathVariable Integer id){
        return studentDao.findById(id).
                orElse(new Student());
    }

    @GetMapping("/student/search/{student-name}")
    public List<Student> getStudentByName(@PathVariable("student-name") String name){
        return studentDao.findAllByfirstName(name);
    }

    @DeleteMapping("/student/delete/:id")
    @ResponseStatus(HttpStatus.OK )
    public void deleteStudent(@PathVariable int id){
         studentDao.deleteById(id);

    }

}
