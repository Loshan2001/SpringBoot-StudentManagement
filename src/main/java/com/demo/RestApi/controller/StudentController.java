package com.demo.RestApi.controller;

import com.demo.RestApi.dao.StudentDao;
import com.demo.RestApi.dto.StudentDto;
import com.demo.RestApi.dto.StudentResponseDto;
import com.demo.RestApi.entity.School;
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
    public StudentResponseDto createStudent(@RequestBody StudentDto stu){
        var student = toStudent(stu);
        var savedStudent = studentDao.save(student);
        return studentResponseDto(savedStudent);
    }

    //    transform studentDto object into student object
    private Student toStudent(StudentDto dto){
        var student = new Student();
        student.setFirstName(dto.firstName());
        student.setLastName(dto.lastName());
        student.setEmail(dto.email());
        student.setAge(dto.age());
    //   create school
        var school = new School();
        school.setId(dto.schoolId());
    //assign to student
        student.setSchool(school);
        return student;

    }

    private StudentResponseDto studentResponseDto(Student student){
        return new StudentResponseDto(
                student.getFirstName(),
                student.getLastName(),
                student.getEmail(),
                student.getAge(),
                student.getSchool().getId()
        );

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
