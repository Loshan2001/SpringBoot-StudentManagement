package com.demo.RestApi.Service;

import com.demo.RestApi.Transfomer.StudentsTransfomer;
import com.demo.RestApi.dao.StudentDao;
import com.demo.RestApi.dto.StudentDto;
import com.demo.RestApi.dto.StudentResponseDto;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public class StudentService {

    private final StudentDao studentDao;
    private final StudentsTransfomer studentsTransfomer;

    // Constructor injection
    public StudentService(StudentDao studentDao, StudentsTransfomer studentsTransfomer) {
        this.studentDao = studentDao;
        this.studentsTransfomer = studentsTransfomer;
    }

    public StudentResponseDto createStudent(StudentDto stu) {
        var student = studentsTransfomer.toStudent(stu);
        var savedStudent = studentDao.save(student);
        return studentsTransfomer.studentResponseDto(savedStudent);
    }

    public List<StudentResponseDto> getAllStudents() {
        return studentDao.findAll()
                .stream()
                .map(studentsTransfomer::studentResponseDto)
                .toList();
    }

    public List<StudentResponseDto> getStudentByName(String name) {
        return studentDao.findAllByfirstName(name)
                .stream()
                .map(studentsTransfomer::studentResponseDto)
                .toList();
    }

    public StudentResponseDto getStudent(Integer id) {
        return studentDao.findById(id)
                .map(studentsTransfomer::studentResponseDto)
                .orElse(null);
    }

    public void deleteStudent(int id) {
        studentDao.deleteById(id);
    }
}
