package com.demo.RestApi.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class School {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private  Integer id;
    private String schoolName;

    @OneToMany(
            mappedBy = "school"
    )
    private List<Student> students;
}
