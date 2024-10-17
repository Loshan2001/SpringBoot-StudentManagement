package com.demo.RestApi.controller;

import com.demo.RestApi.dao.SchoolDao;
import com.demo.RestApi.dto.SchoolDto;
import com.demo.RestApi.entity.School;
import org.springframework.http.converter.feed.RssChannelHttpMessageConverter;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class SchoolController {
    private final SchoolDao schoolDao;

    public SchoolController(SchoolDao schoolDao) {
        this.schoolDao = schoolDao;
    }

    @PostMapping("/school/create")
    public SchoolDto createSchool(@RequestBody SchoolDto schoolDto){
        var school = toSchool(schoolDto);
         schoolDao.save(school);
         return schoolDto;
    }

    private School toSchool(SchoolDto dto) {
        School school = new School();
        school.setSchoolName(dto.schoolName());
        return school;
    }

    @GetMapping("school/getAll")
    public List<SchoolDto> getAllSchool(){
     return schoolDao.findAll()
               .stream()
               .map(this::SchoolDtoToSchool)
                .collect(Collectors.toList());


    }

    private SchoolDto SchoolDtoToSchool(School school){
        return new SchoolDto(school.getSchoolName());
    }


    @GetMapping("school/getSchool/{id}")
    public School getSchool(@PathVariable("id") Integer id){
        return schoolDao.findById(id).orElse(new School());
    }

}
