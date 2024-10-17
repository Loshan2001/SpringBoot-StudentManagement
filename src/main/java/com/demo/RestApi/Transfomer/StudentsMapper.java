package com.demo.RestApi.Transfomer;

import com.demo.RestApi.dto.StudentDto;
import com.demo.RestApi.dto.StudentResponseDto;
import com.demo.RestApi.entity.School;
import com.demo.RestApi.entity.Student;
import org.springframework.stereotype.Service;

@Service
public class StudentsMapper {
    //    transform studentDto object into student object
    public Student toStudent(StudentDto dto){
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

    public StudentResponseDto studentResponseDto(Student student){
        return new StudentResponseDto(
                student.getFirstName(),
                student.getLastName(),
                student.getEmail(),
                student.getAge(),
                student.getSchool().getId()
        );

    }

}
