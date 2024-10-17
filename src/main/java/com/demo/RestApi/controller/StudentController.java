package com.demo.RestApi.controller;

import com.demo.RestApi.Service.StudentService;
import com.demo.RestApi.dto.StudentDto;
import com.demo.RestApi.dto.StudentResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping("/student/create")
    public StudentResponseDto createStudent(@RequestBody StudentDto stu) {
        return this.studentService.createStudent(stu);
    }

    @GetMapping("/student/getAll")
    public List<StudentResponseDto> getAllStudents() {
        return this.studentService.getAllStudents();
    }

    @GetMapping("/student/getStudent/{id}")
    public StudentResponseDto getStudent(@PathVariable Integer id) {
        return studentService.getStudent(id);
    }

    @GetMapping("/student/search/{studentName}")
    public List<StudentResponseDto> getStudentByName(@PathVariable("studentName") String name) {
        return studentService.getStudentByName(name);
    }

    @DeleteMapping("/student/delete/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteStudent(@PathVariable int id) {
        studentService.deleteStudent(id);
    }
}
