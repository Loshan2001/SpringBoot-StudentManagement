package com.demo.RestApi.controller;

import com.demo.RestApi.dao.SchoolDao;
import com.demo.RestApi.entity.School;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SchoolController {
    private final SchoolDao schoolDao;

    public SchoolController(SchoolDao schoolDao) {
        this.schoolDao = schoolDao;
    }

    @PostMapping("/school/create")
    public School createSchool(@RequestBody School school){
        return schoolDao.save(school);
    }

    @GetMapping("school/getAll")
    public List<School> getAllSchool(){
        return schoolDao.findAll();
    }

    @GetMapping("school/getSchool/{id}")
    public School getSchool(@PathVariable("id") Integer id){
        return schoolDao.findById(id).orElse(new School());
    }

}
